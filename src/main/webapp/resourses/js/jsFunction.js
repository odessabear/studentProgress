function deleteDiscipline() {
    var checkboxes = document.getElementsByName("idDisc");
    var checkboxesChecked = '';

    // loop over them all
    for (var i = 0; i < checkboxes.length; i++) {
        // And stick the checked ones onto an array...
        if (checkboxes[i].checked) {
            checkboxesChecked = checkboxesChecked + checkboxes[i].value + '|';
            console.log("You checked" + checkboxesChecked);

        }
    }

    if (checkboxesChecked.length == 0) {
        alert("Ни один из элементов не выбран");
        return;
    }

    var data = '<form id="formdelete" action="/discipline-delete" method="post"><input type="hidden" name="checkboxes"value="' + checkboxesChecked + '"/></form>'
    document.getElementById('formDeleteDiv').innerHTML = data;
    document.getElementById("formdelete").submit();
}

function modifyDiscipline() {
    var checkedboxes = document.querySelectorAll('input[type="checkbox"]:checked');
    var count = checkedboxes.length;

    if (count == 0) {
        alert("Ни один из элементов не выбран");
        return;
    }

    if (count > 1) {
        alert("Вы можете выбрать только одну дсциплину");
        return;
    }

    document.getElementById("checkboxesModify").value = checkedboxes[0].value;
    document.getElementById("formModify").submit();
}


function modifyStudent() {
    var checkedboxes = document.querySelectorAll('input[type="checkbox"]:checked');
    var count = checkedboxes.length;

    if (count == 0) {
        alert("Ни один из элементов не выбран");
        return;
    }

    if (count > 1) {
        alert("Вы можете выбрать только одного студента");
        return;
    }

    document.getElementById("checkboxesModify").value = checkedboxes[0].value;
    document.getElementById("formModify").submit();
}

function deleteStudent() {
    var checkboxes = document.getElementsByName("idStudent");
    var checkboxesChecked = '';

    // loop over them all
    for (var i = 0; i < checkboxes.length; i++) {
        // And stick the checked ones onto an array...
        if (checkboxes[i].checked) {
            checkboxesChecked = checkboxesChecked + checkboxes[i].value + '|';
            console.log("You checked" + checkboxesChecked);

        }
    }

    if (checkboxesChecked.length == 0) {
        alert("Ни один из элементов не выбран");
        return;
    }


    var data = '<form id="formdelete" action="/students-deleting" method="post"><input type="hidden" name="checkboxes"value="' + checkboxesChecked + '"/></form>'
    document.getElementById('formDeleteDiv').innerHTML = data;
    document.getElementById("formdelete").submit();
}

function modifyTerm() {
    var checkedboxes = document.querySelectorAll('input[type="checkbox"]:checked');
    var count = checkedboxes.length;

    if (count == 0) {
        alert("Nothing is selected");
        return;
    }

    if (count > 1) {
        alert("You can to select only one term");
        return;
    }

    document.getElementById("checkboxesModify").value = checkedboxes[0].value;
    document.getElementById("formModify").submit();
    console.log("You selected termId " + checkedboxes[0].value);
}