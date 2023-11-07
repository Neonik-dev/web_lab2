const form = document.getElementById("sendToServer");
form.addEventListener("submit", function (event) {
    if (!isValid()) {
        event.preventDefault();
    }
});

function isValid() {
    let errorMessage = "";
    if (!validX()) {
        errorMessage += "Incorrect X\n";
    }

    if (!validY()) {
        errorMessage += "Incorrect Y\n";
    }

    if (!validR()) {
        errorMessage += "Incorrect R\n";
    }

    document.getElementById("errorMessage").innerHTML = errorMessage;
    return errorMessage.length === 0;
}

function validR() {
    let r_text = document.getElementById("R-input").value.replaceAll(',', '.');
    if (isNaN(r_text)) {
        return false;
    }
    r_text = parseFloat(r_text);
    return !(isNaN(r_text) || 2 > r_text || r_text > 5);
}

function getR() {
    return parseFloat(document.getElementById("R-input").value.replaceAll(',', '.'));
}

function validY() {
    let y_text = document.getElementById("Y-input").value.replaceAll(',', '.');
    if (isNaN(y_text)) {
        return false;
    }
    y_text = parseFloat(y_text)
    return !(isNaN(y_text) || y_text < -5 || y_text > 5);
}

function validX() {
    const x_select_input= parseInt(document.getElementById("X_input").value);
    return !(isNaN(x_select_input) || -4 > x_select_input || x_select_input > 4);
}

