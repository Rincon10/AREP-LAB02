import { messagesApiClient } from './services/messagesApiClient.js';

//========================Variables========================
let formValues;

const saveBtn = document.getElementById('save-btn');
const getBtn = document.getElementById('get-btn');
const textArea = document.getElementById('message');

//========================Functions========================

const saveMessage = event => {
    console.log('entre');
    event.preventDefault();
    const { value } = event.target;
    updateValues('message', value);
    console.log(formValues);
    messagesApiClient.getSomething();
};

const updateValues = (name, value) => {
    formValues = { ...formValues, [name]: value };
};

const redirect = page => {
    window.location = `/public/${page}`;
};

const clearValues = () => {
    formValues = { message: '' };
};

const clearHTML = () => {
    textArea.value = '';
    clearValues();
    console.log('entre');
};

//========================EventsListeners==================
setEventsListeners();

function setEventsListeners() {
    console.log('events');
    document.addEventListener('DOMContentLoaded', () => {
        clearHTML();
    });

    saveBtn?.addEventListener('click', saveMessage);
}
