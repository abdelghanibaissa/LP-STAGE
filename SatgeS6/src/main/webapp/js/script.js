// creation de tabs pour crud

let tabs = document.querySelectorAll(".tabs li");
let tabsArray = Array.from(tabs);
let divs = document.querySelectorAll(".content > div");
let divsArray = Array.from(divs);

// console.log(tabsArray);

tabsArray.forEach((ele) => {
  ele.addEventListener("click", function (e) {
    // console.log(ele);
    tabsArray.forEach((ele) => {
      ele.classList.remove("active");
    });
    e.currentTarget.classList.add("active");
    divsArray.forEach((div) => {
      div.style.display = "none";
    });
    // console.log(e.currentTarget.dataset.cont);
    document.querySelector(e.currentTarget.dataset.cont).style.display = "block";
  });
});
// la selection de ligne de tableau
var table = document.getElementById("table"),rIndex;
for(var i = 1; i < table.rows.length; i++)
{
    table.rows[i].onclick = function()
    {
        rIndex = this.rowIndex;
        console.log(rIndex);
        document.getElementById("nom1").value = this.cells[0].innerHTML;
        document.getElementById("prenom1").value = this.cells[1].innerHTML;
        document.getElementById("nom2").value = this.cells[0].innerHTML;
        document.getElementById("prenom2").value = this.cells[1].innerHTML;
    };
}

//scroll up
let span = document.querySelector(".up");

window.onscroll = function () {
   console.log(this.scrollY);
   if (this.scrollY >= 1000) {
     span.classList.add("show");
   } else {
     span.classList.remove("show");
   }
  this.scrollY >= 1000 ? span.classList.add("show") : span.classList.remove("show");
};

span.onclick = function () {
  window.scrollTo({
    top: 0,
    behavior: "smooth",
  });
};

