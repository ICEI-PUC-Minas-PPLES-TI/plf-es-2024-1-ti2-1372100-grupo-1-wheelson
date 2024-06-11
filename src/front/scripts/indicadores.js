import Dashboards from 'src/front/scripts/dashboards.src.js';

const plotLines = [{
    label: {
        text: 'Today',
        align: 'left',
        rotation: 0,
        y: 0
    },
    value: Date.UTC(2023, 5, 2),
    zIndex: 7
}];

Highcharts.setOptions({
    credits: {
        enabled: false
    },
    title: {
        text: ''
    }
});

Dashboards.board('container', {
    dataPool: {
        connectors: [{
            id: 'taxaMensalAlugueis',
            type: 'JSON',
            dataProcessor: function(connector) {
                return new Promise((resolve, reject) => {
                    fetch('/aluguel/taxaMensal')
                        .then(response => response.json())
                        .then(data => {
                            resolve({
                                data: data.map(item => [item.mes, item.taxa])
                            });
                        })
                        .catch(error => reject(error));
                });
            }
        }, {
            id: 'duracaoMediaReservas',
            type: 'JSON',
            dataProcessor: function(connector) {
                return new Promise((resolve, reject) => {
                    fetch('/aluguel')
                        .then(response => response.json())
                        .then(data => {
                            const durations = data.map(aluguel => {
                                const inicio = new Date(aluguel.inicio);
                                const fim = new Date(aluguel.fim);
                                return (fim - inicio) / (1000 * 60 * 60); // Duração em horas
                            });
                            const averageDuration = durations.reduce((acc, duration) => acc + duration, 0) / durations.length;
                            resolve({
                                data: [['Car', 'Average Duration'], ...durations.map((duration, index) => [`Car ${index + 1}`, duration])]
                            });
                        })
                        .catch(error => reject(error));
                });
            }
        }, {
            id: 'frequenciaAluguelPorVeiculo',
            type: 'JSON',
            dataProcessor: function(connector) {
                return new Promise((resolve, reject) => {
                    fetch('/aluguel/alugueis')
                        .then(response => response.json())
                        .then(data => {
                            const totalAlugueis = data.length;
                            const alugueisPorCarro = data.reduce((acc, aluguel) => {
                                acc[aluguel.carroId] = (acc[aluguel.carroId] || 0) + 1;
                                return acc;
                            }, {});
                            const frequenciaAluguel = Object.keys(alugueisPorCarro).map(carroId => [`Car ${carroId}`, alugueisPorCarro[carroId] / totalAlugueis]);
                            resolve({
                                data: [['Car', 'Frequency'], ...frequenciaAluguel]
                            });
                        })
                        .catch(error => reject(error));
                });
            }
        }]
    },
    components: [{
        renderTo: 'dashboard-chart-1',
        type: 'Highcharts',
        title: 'Taxa de alugueis feitas no mês',
        connector: {
            id: 'taxaMensalAlugueis'
        },
        chartOptions: {
            chart: {
                type: 'column'
            },
            xAxis: {
                type: 'category',
                accessibility: {
                    description: 'Month'
                }
            },
            yAxis: {
                title: {
                    text: 'Taxa'
                }
            },
            legend: {
                enabled: false
            }
        }
    }, {
        renderTo: 'dashboard-chart-2',
        type: 'Highcharts',
        title: 'Duração média das reservas',
        connector: {
            id: 'duracaoMediaReservas'
        },
        chartOptions: {
            chart: {
                type: 'bar'
            },
            xAxis: {
                type: 'category',
                accessibility: {
                    description: 'Car'
                }
            },
            yAxis: {
                title: {
                    text: 'Average Duration'
                }
            },
            legend: {
                enabled: false
            }
        }
    }, {
        renderTo: 'dashboard-chart-3',
        type: 'Highcharts',
        title: 'Frequência de Aluguel por Veículo',
        connector: {
            id: 'frequenciaAluguelPorVeiculo'
        },
        chartOptions: {
            chart: {
                type: 'line'
            },
            xAxis: {
                type: 'category',
                accessibility: {
                    description: 'Car'
                }
            },
            yAxis: {
                title: {
                    text: 'Frequency'
                }
            },
            legend: {
                enabled: false
            }
        }
    }]
}, true).then(dashboard => {
    console.log('Dashboard initialized successfully');
});
