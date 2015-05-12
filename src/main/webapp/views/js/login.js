Ext.onReady(function(){
    Ext.QuickTips.init();
 
	// 表单面板 
    var login = new Ext.FormPanel({ 
        labelWidth:80,
        url:'/thomweboss/login', 
        frame:true, 
        title:'请登录', 
        defaultType:'textfield',
        monitorValid:true,
		
        // 表单的内容
        items:[{ 
                fieldLabel:'用户名', 
                name:'loginUsername', 
                allowBlank:false 
            },{ 
                fieldLabel:'密码', 
                name:'loginPassword', 
                inputType:'password', 
                allowBlank:false 
            }],
 
        // 表单的按钮    
        buttons:[{ 
            text:'登录',
            formBind: true,	 
            // 点击事件
            handler:function(){ 
                login.getForm().submit({ 
                    method:'POST', 
                    waitTitle:'连接', 
                    waitMsg:'发送请求...',
 
		            // 成功的回调函数
		            success:function(){
		            	// alert（标题，消息，点击按钮执行的函数，作用域）
		            	Ext.Msg.alert('提示', '登录成功!', function(btn, text){
		            		if (btn == 'ok') {
		            			var redirect = '/thomweboss/welcome'; 
		            			window.location = redirect;
		            		}
				        });
		            },
 
		            // 失败的回调函数
	                failure:function(form, action){ 
	                    if(action.failureType == 'server'){ 
	                        obj = Ext.util.JSON.decode(action.response.responseText); 
	                        Ext.Msg.alert('登录失败!', obj.reason); 
	                    }else{ 
	                        Ext.Msg.alert('警告!', '服务器出现异常 : ' + action.response.responseText); 
	                    } 
	                    login.getForm().reset(); 
	                } 
                }); 
            } 
        }] 
    });
 
 
	// 创建含表单的窗口     
    var win = new Ext.Window({
        layout:'fit',
        width:300,
        height:150,
        closable: false,
        resizable: false,
        plain: true,
        border: false,
        items: [login]
	});
	win.show();
});