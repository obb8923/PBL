function openPopupContainer(){
    document.getElementById('popupContainer').style.display = 'flex';
}

function closePopupContainer(){
    document.getElementById('popupContainer').style.display = 'none';

}
function clickADDButton() {
    document.getElementById('ADDButton').
    addEventListener('click', function () {
        document.getElementById('popup').style.display = 'flex';
        openPopupContainer();
    });
}
function closePopup(buttonId,popupId) {
    closePopupContainer();
    console.log("ad");
    document.getElementById(buttonId).
    addEventListener('click', function () {
        document.getElementById(popupId).style.display = 'none';
    });
    console.log("add");
}

function confirmAdd() {
    var companyName = document.getElementById('addCompanyName').value;
    var ADName = document.getElementById('addADName').value;
    var ADCondition = document.getElementById('addADCondition').value;
    var slot = document.getElementById('addSlot').value;
    var cost = document.getElementById('addCost').value;
    var dayStart = document.getElementById('addDayStart').value;
    var dayEnd = document.getElementById('addDayEnd').value;

    if (companyName === "" || ADName === "" || ADCondition==="" || slot===""||cost===""||dayStart===""||dayEnd==="") {
        alert("값을 입력하지 않았습니다.");
    }
    else {
        document.getElementById('confirmAdd').addEventListener('click', function () {
            document.getElementById('popupContainer').style.display = 'none';
        });
    }
}

function clickModify(){
}
function fetchAdDetails(adId) {
}

function clickDetail(adsId) {
    fetchAdDetails(adsId);
    document.getElementById('popupDetail').style.display = 'flex';
    openPopupContainer();

}

function clickDelete() {

}

