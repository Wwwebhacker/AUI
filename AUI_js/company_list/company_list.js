import {clearElementChildren, createLinkCell, createButtonCell, createTextCell} from '../dom_utils.js';
import {getBackendUrl} from '../configuration.js';


window.addEventListener('load', () => {
    fetchCompanyAndDisplay();
    const createForm = document.getElementById('createForm');
    createForm.addEventListener('submit',event => createC(event));
});

function createC(event){
    event.preventDefault();
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            fetchCompanyAndDisplay();
        }
    };
    xhttp.open("POST",getBackendUrl()+'/api/companies/',true);

    const request = {
        'name': document.getElementById('formName').value,
        'age': parseInt(document.getElementById('formAge').value)
    };

    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(request));
    console.log(request);
}

function fetchCompanyAndDisplay(){
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            display(JSON.parse(this.responseText));
        }
    };
    xhttp.open("GET", getBackendUrl() + '/api/companies', true);
    xhttp.send();
    display({
        "companies": [
            {
                "id": 1,
                "name": "New company"
            },
            {
                "id": 2,
                "name": "New company2"
            }
        ]
    })

}

function display(companies){
    let tableBody = document.getElementById('tableBody');
    clearElementChildren(tableBody);
    companies.companies.forEach(company => {
        tableBody.appendChild(createTableRow(company));
    })
}

function createTableRow(company) {
    let tr = document.createElement('tr');
    tr.appendChild(createTextCell(company.name));
    tr.appendChild(createLinkCell('view', '../company_view/company_view.html?company=' + company.id));
    tr.appendChild(createLinkCell('edit', '../company_view/company_edit.html?company=' + company.id));
    tr.appendChild(createButtonCell('delete', () => deleteC(company)));
    return tr;
}



function deleteC(company) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 202) {
            fetchC();
        }
    };
    xhttp.open("DELETE", getBackendUrl() + '/api/companies/' + user, true);
    xhttp.send();
}