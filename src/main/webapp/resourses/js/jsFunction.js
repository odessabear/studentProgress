function deleteDiscipline() {
    var checkboxes = document.getElementsByName("idDisc");
    var checkboxesChecked ='';
    // loop over them all
    for (var i=0; i<checkboxes.length; i++) {
        // And stick the checked ones onto an array...
        if (checkboxes[i].checked) {
            checkboxesChecked=checkboxesChecked + checkboxes[i].value + '|';
        }
    }

    if(checkboxesChecked.length==0){
        alert("Ни один из элементов не выбран");
        return;
    }

    var data='<form id="formdelete" class="create-form" action="/discipline-delete" method="post"><input type="hidden" name="checkboxes"value="'+checkboxesChecked+'"/></form>'
    document.getElementById('formDeleteDiv').innerHTML = data;
    document.getElementById("formdelete").submit();
}