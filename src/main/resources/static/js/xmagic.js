    var tch=0;
    var tchstp=5;
    var maxtch=0;
    var whichone=0;
    var search_vue= new Vue(
        {
            el:"#header_search",
            data:{
                svalue:"在这里输入搜索内容",
                history_search:[],
                hshow:true,
            },
            methods:{
                saveit:function () {
                    this.history_search.unshift(this.svalue);
                    for(i=1;i<this.history_search.length;i++)
                    {
                        if(this.history_search[i]==this.svalue)
                        {
                            this.history_search.splice(i,1);
                            break;
                        }
                    }
                    console.log("aaa");
                },
                deleteit(which)
                {
                    this.history_search.splice(which,1);
                }
            }
        }
    );
    var tourist_vue= new Vue(
        {
            el:"#tourist",
            data:{
                tli:[
                    {content:"三坑笔记",isshow:false,slcontent:["汉服","Lolita","JK"]},
                    {content:"三坑笔记",isshow:false,slcontent:["汉服","Lolita","JK"]},
                    {content:"三坑笔记",isshow:false,slcontent:["汉服","汉服","汉服","Lolita","JK"]},
                    {content:"我的收藏",isshow:false,slcontent:["西装","皮鞋","袈裟"]},
                    {content:"发布笔记",isshow:false,slcontent:["中山装","道袍","比基尼"]},
                    {content:"嗯嗯啊啊",isshow:false,slcontent:["长靴","礼帽","披风"]},
                    {content:"栖栖遑遑",isshow:false,slcontent:["马褂","旗袍","水手服"]},
                    {content:"栖栖遑遑",isshow:false,slcontent:["马褂","旗袍","水手服"]},
                    {content:"栖栖遑遑",isshow:false,slcontent:["马褂","旗袍","水手服"]},
                ]

            },
            methods:{
                showit:function (which) {
                    for(i=0;i<this.tli.length;i++){
                        if(i!=which)
                            this.tli[i].isshow=false;
                    }
                    maxtch=this.tli[which].slcontent.length*31+5;
                    tch=0;
                    whichone=which;
                    this.tli[which].isshow=!(this.tli[which].isshow);
                }
            }
        },
        setInterval(function () {
            var idname="showtlic";
            var a=document.getElementById(idname);
            //console.log(tch);
            tch+=tchstp;
            if(a!=null){
                if(tch>=maxtch)
                    a.style.height=maxtch+'px';
                else
                    a.style.height=tch+'px';
            }


        },20));






