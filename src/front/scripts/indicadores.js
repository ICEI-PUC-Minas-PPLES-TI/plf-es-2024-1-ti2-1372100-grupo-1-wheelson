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
            options: {
                data: [
                    ['Month', 'Taxa'],
                    ['Jan', 20],
                    ['Feb', 30],
                    ['Mar', 40],
                    ['Apr', 50],
                    ['May', 60],
                    ['Jun', 70],
                    ['Jul', 80],
                    ['Aug', 90],
                    ['Sep', 100],
                    ['Oct', 110],
                    ['Nov', 120],
                    ['Dec', 130]
                ]
            }
        }, {
            id: 'duracaoMediaReservas',
            type: 'JSON',
            options: {
                data: [
                    ['Car', 'Average Duration'],
                    ['Car 1', 10],
                    ['Car 2', 20],
                    ['Car 3', 30],
                    ['Car 4', 40],
                    ['Car 5', 50],
                    ['Car 6', 60],
                    ['Car 7', 70],
                    ['Car 8', 80],
                    ['Car 9', 90],
                    ['Car 10', 100]
                ]
                
            }
        }, {
            id: 'frequenciaAluguelPorVeiculo',
            type: 'JSON',
            options: {
                data: [
                    ['Car', 'Frequency'],
                    ['Car 1', 5],
                    ['Car 2', 10],
                    ['Car 3', 15],
                    ['Car 4', 20],
                    ['Car 5', 25],
                    ['Car 6', 30],
                    ['Car 7', 35],
                    ['Car 8', 40],
                    ['Car 9', 45],
                    ['Car 10', 50]
                ]
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
        },
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
        },
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
}, true).then(dashboard => {
    // Implementação final do dashboard
});