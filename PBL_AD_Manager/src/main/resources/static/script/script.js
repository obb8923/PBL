function openPopupContainer(){
    document.getElementById('popupContainer').style.display = 'flex';
}
function closePopupContainer(){
    document.getElementById('popupContainer').style.display = 'none';

}

function closePopup(popupId) {
    closePopupContainer();
    document.getElementById(popupId).style.display = 'none';
}
function confirmAdd() {
    var companyName = document.getElementById('addCompanyName').value;
    var ADName = document.getElementById('addADName').value;
    var AgeCondition = document.getElementById('addAgeCondition').value;
    var genderCondition = document.getElementById('addGenderCondition').value;
    var slot = document.getElementById('addSlot').value;
    var cost = document.getElementById('addCost').value;
    var dayStart = document.getElementById('addDayStart').value;
    var dayEnd = document.getElementById('addDayEnd').value;

    if (companyName === "" || ADName === "" || genderCondition === "" || AgeCondition === "" || slot === "" || cost === "" || dayStart === "" || dayEnd === "") {
        alert("값을 모두 입력하지 않았습니다.");
    } else {
        closePopup('popupAdd');
    }
}
function openPopup(popupId) {
    openPopupContainer();
    document.getElementById(popupId).style.display = 'flex';
}

function submitUI() {

}
function paginatiom(){
    window.location.href = 'http://localhost:8080/hi/1';
}
