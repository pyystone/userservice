用户除了登录以外，其他时候必须使用token进行验证，如果token验证不过，需要重新登录


系统有2个token
1. accessToken 有效期3天
2. refreshToken 有效期7天，用户刷新accessToken

如果refreshToken过期，无法刷新，就需要客户重新登录


token 更新机制

更新
1. 用户登录 创建（更新）
2. 用户退出 删除
3. 用户过期 判断refreshToken 刷新 2个 token


token 生成方式

MD5(userid + password + timestamp + sign_key)