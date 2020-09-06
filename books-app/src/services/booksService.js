
const getAll = async (searchParam) => await fetch(`http://localhost:8080/books`, {
        method: 'GET',
        body : searchParam
    })
    .then(response => response.json()).catch(error => console.error(error));


const getRecommendation = async (recommendationDTO) => await fetch(`http://localhost:8080/books/getTopTen`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(recommendationDTO)
    })
    .then(response => response.json()).catch(error => console.error(error));



export default {getAll, getRecommendation}
