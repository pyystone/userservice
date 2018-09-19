#### api_list
| API名字 | API URL |
| :---- | :---- |
| 用户注册 | /api/user/register |
| 用户登录 | /api/user/login |
| 用户信息 | /api/user/{id} |
| 忘记密码 | /api/user/forget |



####Error Code List

|code编号|备注|
|-----|-----|
|101101001| 账号密码错误|
|101101002| 请重新登录|
|101101003| token过期|




##### 用户登录

类别: post

|字段名|字段说明|
|----|----|
|account| 用户名|
|ts|当前时间戳|
|r|随机10位数字|
|pwd|MD5(MD5(MD5(用户密码)+sign)+ts+r)|


##### 用户注册

类别: post

|字段名|字段说明|
|----|----|
|email|邮箱|
|pwd|(MD5(用户密码)|


##### 忘记密码

类别: web

|字段名|字段说明|
|----|----|
|stoken| 验证码|

类别：post

|字段名|字段说明|
|----|----|
|stoken| 验证码|
|pwd|(MD5(用户密码)|
