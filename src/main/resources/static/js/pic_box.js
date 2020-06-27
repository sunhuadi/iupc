
var pic1=document.getElementById("pic1");
var pic2=document.getElementById("pic2");
var pic3=document.getElementById("pic3");
var boxs=document.getElementById("pic_box");
var n=0;
var l=boxs.clientWidth;
var fx=1;
var v=0.001;
var wt=0.2;
var sdbox1=document.getElementById("side_box1");
var sdbox2=document.getElementById("side_box2");
var cn=0;
var cnmx=10;
var topmax=300;
var clickwaitime=10;
var lasttop1,lasttop2;
var stp1=1,stp2=-1;
var lck1=0,lck2=0;
var st=0;
function ds(p1,p2,p3)
{
    l=boxs.clientWidth;
    var h=l/2;
    n=n+fx*v;//长度比例
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
    var nn;//实际长度比例
    if(n>=1)
    {
        nn=1;
    }
    else if(n<=0)
    {
        nn=0;
    }
    else nn=n;
    if(1){
        if(st==0)
            sdbox2.scrollTop+=topmax;
        st=1;
        cn++;
        if(cn%cnmx==0){
            if(lck1==0)
                sdbox1.scrollTop+=stp1;
            else
                lck1--;
            if(lck2==0)
                sdbox2.scrollTop+=stp2;
            else
                lck2--;
            if(lasttop1-sdbox1.scrollTop==0)
                stp1*=-1;
            else if (Math.abs(lasttop1-sdbox1.scrollTop)>2)
                lck1+=clickwaitime;
            if(lasttop2-sdbox2.scrollTop==0)
                stp2*=-1;
            else if (Math.abs(lasttop2-sdbox2.scrollTop)>2)
                lck2+=clickwaitime;
            lasttop1=sdbox1.scrollTop;
            lasttop2=sdbox2.scrollTop;
        }
    }
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
