var bean = __.newBean('me.myklebust.xp.app.versiontest.TestBean');

// invoked from <server:port>/webapp/me.myklebust.xp.app.versiontest
exports.get = function (req) {

    log.info("Execute bean");
    bean.execute();

    return {
        contentType: 'text/html',
        body: "<html><head>fisk</head><body><h1>ost</h1></body></html>"
    }
};
