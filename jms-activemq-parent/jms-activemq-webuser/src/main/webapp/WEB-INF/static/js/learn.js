

	//js模块化的使用方式
	var func = $.extend({},func);//定义一个模块
	func.test1 = function(){
		alert("test1");
	};
	func.test2 = function(){
		alert("test2");
	};
	// 调用
	func.test2();
	
	
	
	
	