<template>
    <!-- <div id="vueBox">	
        <div class="square" v-for="(item,$index) in squareList" 
            @dragstart="dragstart($index,$event)"
            @dragend="dragend($event)" @drop="drop($index,$event)" @dragover="dragover($event)" 
            draggable="true">我是移动的模块儿{{item.index}}</div>
        <div class="big_box" @drop="drop($event)" @dragover="allowDrop($event)"></div>
    </div> -->
    <div class="scroll-box">
        <Scroll :on-reach-bottom="handleReachBottom" :height="500">
            <Card dis-hover v-for="(item, index) in list1" :key="index" style="margin: 32px 0">
                Content {{ item }}
            </Card>
        </Scroll>
    </div>
</template>
<script>
export default {
    data(){
        return{
            // squareList:[],
			// moveIndex:null,
            // targetIndex:null,
            list1: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10,]
        }
    },
    methods:{
        // 拖拽
        // dragstart:function(index){
        //     var that = this;
        //     console.log("拖放开始",index);
        //     that.moveIndex = index;
        // },
        // dragover:function(event){  //必须添加dragover事件，不然drop事件也无效
        //     event.preventDefault(); 
        // },
        // dragend:function(event){
        //     console.log("拖放结束",event.currentTarget);
        // },
        // drop:function(index,event){
        //     var that = this;
        //     //阻止默认行为
        //     event.preventDefault();
        //     //阻止默认行为
        //     event.stopPropagation();
        //     console.log("拖放到目标",index);
        //     that.targetIndex = index;
            
        //     //先保存拖动元素index
        //     var temp = that.squareList[that.moveIndex].index;
        //     //将拖动元素位置index换成目标元素的index
        //     that.squareList[that.moveIndex].index = that.squareList[that.targetIndex].index;
        //     //将目标元素位置index换成拖动元素的index
        //     that.squareList[that.targetIndex].index = temp;
        //     console.log(JSON.stringify(that.squareList));
        // },
        // allowDrop:function(event){
        //     event.preventDefault();  
        // },
        // getSquareList:function(){
        //     var that = this;
        //     for(var i=0;i<4;i++){
        //         (function(i){
        //             var obj = {
        //                 index:i,							
        //             }
        //             that.squareList.push(obj);
        //         }(i))
        //     }
        // },
        // 滚动加载更多
        handleReachBottom () {
            return new Promise(resolve => {
                setTimeout(() => {
                    const last = this.list1[this.list1.length - 1];
                    for (let i = 1; i < 11; i++) {
                        this.list1.push(last + i);
                        // console.log(last)
                    }
                    resolve();
                }, 2000);
            });
        }
        
    },
    mounted:function(){
        // this.getSquareList();
    }
}
</script>
<style scoped>
	.square{
		width:48%;
		height: 200px;
		line-height: 50px;
		margin-bottom: 60px;
		text-align: center;
		background-color: #5BC0DE;
		font-size: 20px;
		color: #fff;
        display:inline-block;
        margin-right:2%;
	}
	.big_box{
		width: 400px;
		height: 200px;
		background-color: #006600;
	}
</style>