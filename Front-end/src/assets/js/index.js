import { messagesApiClient } from '../js/services/messagesApiClient.js';

//========================Variables========================
let formValues;

const form = document.getElementById('form');
const textArea = document.getElementById('message');
const pre = document.getElementById('code');

//========================Functions========================

const saveMessage = event => {
    const { value } = event.target;
    updateValues('description', value);
};

const updateHTML = () => {
    messagesApiClient
        .getMessages()
        .then(messages => {
            pre.innerHTML = messages;
        })
        .catch(error => console.log(error));
};

const postMessage = event => {
    event.preventDefault();
    console.log('entree');
    messagesApiClient
        .postMessage(formValues)
        .then(response => {
            console.log(response);
            updateHTML();
        })
        .catch(error => console.log(error));
};

const updateValues = (name, value) => {
    formValues = { ...formValues, [name]: value };
};

const redirect = page => {
    window.location = `/public/${page}`;
};

const clearValues = () => {
    formValues = { description: '' };
};

const clearHTML = () => {
    textArea.value = '';
    clearValues();
};

//========================EventsListeners==================
setEventsListeners();

function setEventsListeners() {
    document.addEventListener('DOMContentLoaded', () => {
        clearHTML();
    });

    textArea?.addEventListener('change', saveMessage);

    form?.addEventListener('submit', postMessage);
}
