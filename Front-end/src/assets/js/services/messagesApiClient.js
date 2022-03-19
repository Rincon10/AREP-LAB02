export const messagesApiClient = (() => {
    /* const URL = 'http://ec2-52-207-142-166.compute-1.amazonaws.com:35000'; */
    const URL = 'http://localhost:4566';

    const myHeader = new Headers();
    myHeader.set('Content-Type', 'application/json');
    myHeader.set('Access-Control-Allow-Origin', '*');

    return {
        getMessages: async () => {
            const response = await fetch(`${URL}/balancer`, {
                method: 'GET',
                headers: myHeader,
            });
            if (!response.ok) throw new Error('The response failed');
            return response.json();
        },

        postMessage: async message => {
            const response = await fetch(`${URL}/balancer`, {
                method: 'POST',
                headers: myHeader,
                body: JSON.stringify(message),
            });
            if (!response.ok) throw new Error('The response failed');
            return response.json();
        },
    };
})();
