import { messagesApiClient } from '../js/services/messagesApiClient.js';

//========================Variables========================
let formValues;

const form = document.getElementById('form');
const getBtn = document.getElementById('get-btn');
const textArea = document.getElementById('message');

//========================Functions========================

const saveMessage = event => {
    const { value } = event.target;
    updateValues('message', value);
};

const postMessage = event => {
    event.preventDefault();
    console.log(formValues);
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
