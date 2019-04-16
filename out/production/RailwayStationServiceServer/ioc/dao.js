var ioc = {
    dataSource : {
        type : "com.alibaba.druid.pool.DruidDataSource",
        events : {
            create : "init",
            depose : 'close'
        },
        fields : {
            url : "jdbc:mysql://127.0.0.1:3306/railway_station?useUnicode=true&characterEncoding=UTF8",
            username : "root",
            password : "123",
            testWhileIdle : true,
            validationQuery : "select 1" ,
            maxActive : 100
        }
    },
    dao : {
        type : "org.nutz.dao.impl.NutDao",
        args : [{refer:"dataSource"}]
    },
    tmpFilePool : {
        type : 'org.nutz.filepool.NutFilePool',
        // 临时文件最大个数为 1000 个
        args : [ "~/nutz/blog/upload/tmps", 1000 ]
    },
    uploadFileContext : {
        type : 'org.nutz.mvc.upload.UploadingContext',
        singleton : false,
        args : [ { refer : 'tmpFilePool' } ],
        fields : {
            // 是否忽略空文件, 默认为 false
            ignoreNull : true,
            // 单个文件最大尺寸(大约的值，单位为字节，即 1048576 为 1M)
            maxFileSize : 104857600,
            // 正则表达式匹配可以支持的文件名
            nameFilter : '^(.+[.])(gif|jpg|png|doc|docx|ppt|pptx|xls|xlsx|pdf|txt|mp3|mp4|rar|zip|7z|gz|wav)$'
        }
    },
    myUpload : {
        type : 'org.nutz.mvc.upload.UploadAdaptor',
        singleton : false,
        args : [ { refer : 'uploadFileContext' } ]
    }
};