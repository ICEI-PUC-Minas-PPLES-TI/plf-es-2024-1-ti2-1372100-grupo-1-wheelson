document.addEventListener("DOMContentLoaded", function() {
    const containerNresolvido= document.getElementById("problemasNaoResolvidos-container");
    const containerResolvidos= document.getElementById("problemasResolvidos-container");

    fetchProblemasNaoResolvidos(containerNresolvido);

    fetchProblemasResolvidos(containerResolvidos);

    function fetchProblemasNaoResolvidos(containerNresolvido) {
        fetch(`http://localhost:8080/problema/naoResolvido`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => /*createProblemaCards(data,containerNresolvido),*/ console.log(data))
            .catch(error => console.error('Error fetching problemas:', error));
    }

    function fetchProblemasResolvidos(containerResolvidos) {
        fetch(`http://localhost:8080/problema/resolvido`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => /*createProblemaCards(data,containerResolvidos),*/ console.log(data))
            .catch(error => console.error('Error fetching problemas:', error));
    }
});