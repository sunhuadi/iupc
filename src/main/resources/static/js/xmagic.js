/*
 * 侧边栏
 * 导航栏
 */
var tch=0;
var tchstp=7;
var maxtch=0;
var whichone=0;
var tourist_vue= new Vue(
    {
        el:"#tourist",
        data:{
            tli:[
                {content:"三坑笔记",
                    isshow:false,
                    slcontent:[
                        {name:"汉服",link:"/zxck"},
                        {name:"Lolita",link:""},
                        {name:"JK",link:""},
                        {name:"更多",link:""},
                    ]
                },
                {content:"我的收藏",
                    isshow:false,
                    slcontent:[
                        {name:"资讯",link:""},
                        {name:"笔记",link:""},
                        {name:"商品",link:""},
                    ]
                },
                {content:"我的收藏",
                    isshow:false,
                    slcontent:[
                        {name:"资讯",link:""},
                        {name:"笔记",link:""},
                        {name:"商品",link:""},
                    ]
                },
            ]
        },
        methods:{
            showit:function (which) {
                for(i=0;i<this.tli.length;i++){
                    if(i!=which)
                        this.tli[i].isshow=false;
                }
                maxtch=this.tli[which].slcontent.length*33+5;
                tch=0;
                whichone=which;
                this.tli[which].isshow=!(this.tli[which].isshow);
            }
        }
    },
    setInterval(function () {
        var idname="showtlic";
        var a=document.getElementById(idname);
        tch+=tchstp;
        if(a!=null){
            if(tch>=maxtch)
                a.style.height=maxtch+'px';
            else
                a.style.height=tch+'px';
        }
    },20));
/*
 * 搜索
 */
var snsh;
var search_vue= new Vue(
    {
        el:"#header_search",
        data:{
            svalue:"",
            history_search:[],
            filtersearch:[],
            hshow:false,
            stopunshow:false,
        },
        methods:{
            saveit:function () {
                this.svalue=this.svalue.trim();
                if(this.svalue=="")
                {
                    alert("搜索内容不能为空");
                }
                else{
                    this.history_search.unshift(this.svalue);
                    for(i=1;i<this.history_search.length;i++)
                    {
                        if(this.history_search[i]==this.svalue)
                        {
                            this.history_search.splice(i,1);
                            break;
                        }
                    }
                    sessionStorage.setItem("history_search",JSON.stringify(this.history_search));
                    sessionStorage.setItem("search_keyword",this.svalue);
                    window.location.href="/search_result";
                }
            },
            deleteit(which)
            {
                this.hshow=true;
                this.history_search.splice(which,1);
                sessionStorage.setItem("history_search",JSON.stringify(this.history_search));
            },
            doshowit()
            {
                snhs=JSON.parse(sessionStorage.getItem("history_search"));
                console.log(snhs);
                if(snhs!=null){
                    this.history_search=snhs;
                    if(this.history_search.length>0)
                        this.hshow=true;
                }
            },
            unshowit(){
                if(!this.stopunshow)
                    this.hshow=false;
            },
        }
    }
);
/*
 *news 组件
 * myclassname  设置class
 * news_title   设置标题
 * news_img     设置图片地址
 * news_content 设置内容，当字数大于200时会截取到200
 * news_id      设置news的id，用于跳转
 * news_time    设置news发布时间
 */
Vue.component("news",{
    template:`
        <div :class="myclassname">
        <img class="zxi_pic" :src="news_img" />
        <img class="zxi_pic_fly" src="image/透明蓝色蝴蝶结.gif">
        <div class="zxi_text">
        <p class="zxi_title" @click="readthisnews" >{{ news_title }}</a></p>
        <p class="zxi_content">{{ shortifycontent }}</p>
        <p class="zxi_time" >{{ news_time }}</p>
        </div>
        </div>`,
    props:{
        news_title:String,
        news_id:String,
        news_time:String,
        news_img:String,
        news_content:String,
        myclassname:String,
    },
    computed:{
        shortifycontent(){
            if(this.news_content.length<=150)
            return this.news_content;
            else
            return this.news_content.slice(0,100)+"...";
        }
    },
    methods:{
        readthisnews()
        {
            sessionStorage.setItem("mynews_id",this.news_id);
            window.location.href="/zxck";
        }
    }
})
/*
 * 返回按钮组件
 *  myclassname 设置class
 */
Vue.component("gotoback",{
    template:`
        <span :class="myclassname"  @click="dogoback" >返回</span>
    `,
    methods: {
        dogoback(){
            history.back();
        }
    },
    props: {
        myclassname: String,
    }
});

var setvue=new Vue({
    el:"#header_setting",
    data: {
        bgsisshow:false,
        bgslist:[
        ],

    },
    methods:{
        bgsettingshow() {
            this.bgsisshow=!this.bgsisshow;
            console.log("showit");
        },
        changebg(which){
            document.documentElement.style.setProperty("--bgimg",'url("'+this.bgslist[which].var+'")')
            sessionStorage.setItem("bgpic",this.bgslist[which].var);
        }

    }

},)
var now_bg=sessionStorage.getItem("bgpic");
if(now_bg!=null)
{
    document.documentElement.style.setProperty("--bgimg",'url("'+now_bg+'")');
}
for(var i=1;i<21;i++){
    var bgp={src:"",var:""};
    bgp.src="image/background/"+i+".jpg";
    console.log(bgp.src);
    bgp.var="../"+bgp.src;
    setvue.bgslist.push(bgp);
}