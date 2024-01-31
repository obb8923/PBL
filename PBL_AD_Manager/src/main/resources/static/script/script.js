// function toEx(curPage){
//     const toExButton = document.getElementById('toEX');
//     console.log(curPage+"<<");
//     if(curPage==1 ) {
//         toExButton.style.display = 'none';
//     }else{
//         toExButton.style.display = 'block';
//     }
// }
// function toPost(endPage,curPage){
//     const toPostButton = document.getElementById('toPost');
//     console.log(typeof(curPage)+"<");
//     console.log(typeof(endPage)+"<");
//     if(curPage===endPage) {
//         toPostButton.style.display = 'none';
//     }else{
//         toPostButton.style.display = 'block';
//     }
// }
function pageButton(totalNum,pageNum){
    let currentPage = pageNum;
    const curButton = document.getElementById("curButton")
    const exButton = document.getElementById("exButton")
    const exexButton = document.getElementById("exexButton")
    const postButton = document.getElementById("postButton")
    const postpostButton = document.getElementById("postpostButton")
    curButton.innerHTML = currentPage;
    exButton.innerHTML = (currentPage - 1);
    exexButton.innerHTML = (currentPage - 2);
    postButton.innerHTML = (currentPage + 1);
    postpostButton.innerHTML = (currentPage + 2);
    if(parseInt(exexButton.innerText)<1 || parseInt(exexButton.innerText)>totalNum) {
        exexButton.style.display = 'none';
    }else{
        exexButton.style.display = 'block';
    }
    if(parseInt(exButton.innerText)<1 || parseInt(exButton.innerText)>totalNum) {
        exButton.style.display = 'none';
    }else{
        exButton.style.display = 'block';
    }
    if(parseInt(curButton.innerText)<1 || parseInt(curButton.innerText)>totalNum) {
        curButton.style.display = 'none';
    }else{
        curButton.style.display = 'block';
    }
    if(parseInt(postButton.innerText)<1 || parseInt(postButton.innerText)>totalNum) {
        postButton.style.display = 'none';
    }else{
        postButton.style.display = 'block';
    }
    if(parseInt(postpostButton.innerText)<1 || parseInt(postpostButton.innerText)>totalNum) {
        postpostButton.style.display = 'none';
    }else{
        postpostButton.style.display = 'block';
    }
    document.exexForm.action='/'+(currentPage-2);
    document.exForm.action='/'+(currentPage-1);
    document.curForm.action='/'+currentPage;
    document.postForm.action='/'+(currentPage+1);
    document.postpostForm.action='/'+(currentPage+2);

    // toEx(curPage);
    // toPost(endPage,curPage);
}
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

function openPopup(popupId) {
    openPopupContainer();
    document.getElementById(popupId).style.display = 'flex';
}
function openIdPopup(popupId, adId){
    openPopup(popupId);
    document.getElementById("adId").value = adId;
}
