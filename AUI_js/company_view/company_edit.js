import {
    getParameterByName,
    clearElementChildren,
    createLinkCell,
    createButtonCell,
    createTextCell,
    createImageCell,
    setTextNode
} from '../dom_utils.js';
import {getBackendUrl} from '../configuration.js';

function fetchAndDisplayCompany() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayCompany(JSON.parse(this.responseText))
        }
    };
    xhttp.open("GET", getBackendUrl() + '/api/companies/' + getParameterByName('company'), true);
    xhttp.send();
    displayCompany({
        "name": "Updated company",
        "age": 32
    })

}

function displayCompany(company) {
    setTextNode('formName', company.name);
    setTextNode('formAge', company.age);
}