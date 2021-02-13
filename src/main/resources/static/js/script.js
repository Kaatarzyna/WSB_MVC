function ajaxGet() {
    axios.get("/api/").then(displayResponse)
}

function ajaxPost() {
    const newPainting = {
        name: "Obraz asynchroniczny",
        author: "AJAX",
        year: "2021"
    };

    axios.post("/api/", newPainting).then(displayResponse)
}

function displayResponse(response) {
    const responseDiv = document.getElementById("response");

    const statusDiv = document.createElement("div");
    statusDiv.className = findStatusClass(response.status);
    statusDiv.innerText = `STATUS: ${response.status}`;

    const dataDiv = document.createElement("pre");
    dataDiv.innerText = JSON.stringify(response.data, null, 2);

    responseDiv.innerHTML = "";
    responseDiv.appendChild(statusDiv);
    responseDiv.appendChild(dataDiv);
}

function findStatusClass(status) {
    const firstNumber = Math.floor(status / 100);

    switch (firstNumber) {
        case 1:
            return "text-secondary";
        case 2:
            return "text-success";
        case 3:
            return "text-primary";
        case 4:
            return "text-warning";
        case 5:
            return "text-danger";
        default:
            return "";
    }
}

function sendWithHeader() {
    let config = {
        headers: {
            Authorization: 'Basic ABC'
        }
    }

    axios.get("/api/auth", config).then(displayResponse);
}

function sendWithCookie() {
    document.cookie = "ciastko_JS=siema";
    document.cookie = "ciastko_JS2=siema;max-age=200";

    axios.get("/api/cookie").then(response => {
        const responseDiv = document.getElementById("response");
        responseDiv.innerText = `${document.cookie}`;
    })
}