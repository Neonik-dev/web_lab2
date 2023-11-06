const form = document.getElementById("sendToServer");
form.addEventListener("submit", function (event) {
    if (!isValid()) {
        event.preventDefault();
    }
});

function isValid() {
    let errorMessage = "";
    const x_select_input= parseInt(document.getElementById("X_input").value);
    if (isNaN(x_select_input) || -4 > x_select_input || x_select_input > 4) {
        errorMessage += "Incorrect X\n";
    }
    
    let y_text = document.getElementById("Y-input").value.replaceAll(',', '.');
    if (!isNaN(y_text)) {
        y_text = parseFloat(y_text)
        if (isNaN(y_text) || y_text < -5 || y_text > 5) {
            errorMessage += "Incorrect Y\n";
        }
    } else {
        errorMessage += "Incorrect Y\n";
    }

    let r_text = document.getElementById("R-input").value.replaceAll(',', '.');
    if (!isNaN(r_text)) {
        r_text = parseFloat(r_text);
        if (isNaN(r_text) || 2 > r_text || r_text > 5) {
            errorMessage += "Incorrect R\n";
        }
    } else {
        errorMessage += "Incorrect R\n";
    }

    document.getElementById("errorMessage").innerHTML = errorMessage;
    return errorMessage.length === 0;
}

