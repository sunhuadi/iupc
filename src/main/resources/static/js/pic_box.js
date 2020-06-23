
var pic1=document.getElementById("pic1");
var pic2=document.getElementById("pic2");
var pic3=document.getElementById("pic3");
var boxs=document.getElementById("pic_box");
var sdbox1=document.getElementById("side_box1");
var sdbox2=document.getElementById("side_box2");
var n=0;
var l=boxs.clientWidth;
var fx=1;
var v=0.001;
var wt=0.8;
var cn=0;
var cnmx=10;
var topmax=185;
var sclock=0;
var tsted=1;
function ds(p1,p2,p3)
{

    l=boxs.clientWidth;
    var h=l/7*3.5;
    n=n+fx*v;
    if(n>=1+wt)
    {
        fx=-1;
        var pic=pic2;
        pic2=pic3;
        pic3=pic;
    }
    if(n<=0-wt)
    {
        fx=1;
        var pic=pic1;
        pic1=pic3;
        pic3=pic;

    }
    var nn;
    if(n>=1)
    {
        nn=1;
    }
    else if(n<=0)
    {
        nn=0;
    }
    else nn=n;
    cn++;
    var rcnmx;
    if(tsted==0){
        rcnmx=1;
    }
    else {
        rcnmx=cnmx;
    }
    if(cn%rcnmx==0){
        sdbox1.scrollTop++;
        sdbox2.scrollTop=topmax-sdbox1.scrollTop;
        if(sclock==sdbox1.scrollTop&&tsted==0)
        {
            topmax=sclock;
            tsted=1;
        }
        sclock=sdbox1.scrollTop;
        if(sdbox1.scrollTop>=topmax)
        {
            sdbox1.scrollTop=0;
        }
    }

    console.log(topmax);
    console.log(sdbox1.scrollTop);
    p1.style.width=nn*l+'px';
    p1.style.left=0;
    p2.style.width=l-nn*l+'px';
    p2.style.left=nn*l+'px';
    p3.style.width=0;
    p1.style.height=h+'px';
    p2.style.height=h+'px';
    p3.style.height=h+'px';
    boxs.style.height=h+10+'px';


}
setInterval("ds(pic1,pic2,pic3)",1);
