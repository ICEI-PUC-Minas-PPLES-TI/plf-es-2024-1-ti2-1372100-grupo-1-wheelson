import Dashboards from 'src/front/scripts/dashboards.src.js';

// Função para buscar dados do backend
const fetchData = (url) => {
    return fetch(url)
        .then(response => response.json())
        .catch(error => console.error('Error fetching data:', error));
};

// Configuração do Highcharts
Highcharts.setOptions({
    credits: {
        enabled: false
    },
    title: {
        text: ''
    }
});

// Dados de exemplo para duracaoMediaReservas
const duracaoMediaReservasData = [
    ['Car', 'Average Duration'],
    ['HB20', 10],
    ['ARGO', 20],
    ['SW4', 30],
    ['STRADA', 40],
    ['MINI', 50],
    ['POLO', 60],
    ['UNO', 70],
    ['CORSA', 80],
    ['HRV', 90],
    ['IDEA', 100]
];

Dashboards.board('container', {
    dataPool: {
        connectors: [{
            id: 'taxaMensalAlugueis',
            type: 'JSON',
            dataProcessor: function(connector) {
                return fetchData('/aluguel/taxa-mensal').then(data => {
                    // Convertendo a resposta do backend para o formato esperado
                    const taxaMensal = Object.keys(data).map(key => [key, data[key]]);
                    return {
                        data: [['Month', 'Taxa'], ...taxaMensal]
                    };
                });
            }
        }, {
            id: 'duracaoMediaReservas',
            type: 'JSON',
            options: {
                data: duracaoMediaReservasData
            }
        }, {
            id: 'frequenciaAluguelPorVeiculo',
            type: 'JSON',
            dataProcessor: function(connector) {
                return fetchData('/aluguel/alugueis').then(data => {
                    const totalAlugueis = data.length;
                    const alugueisPorCarro = data.reduce((acc, aluguel) => {
                        acc[aluguel.carro.id] = (acc[aluguel.carro.id] || 0) + 1;
                        return acc;
                    }, {});
                    const frequenciaAluguel = Object.keys(alugueisPorCarro).map(carroId => [`Car ${carroId}`, alugueisPorCarro[carroId] / totalAlugueis]);
                    return {
                        data: [['Car', 'Frequency'], ...frequenciaAluguel]
                    };
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
