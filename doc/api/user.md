/api/register : post
``` json
request:
{
	username:"pyystone" string,
	password:"ajdsncuaneuw" string((md5)md5),
	nickname:"pyystone" string,
	email:"pyystone@163.com" string
}

response:
{
	code:0,
	error:"",
	data:
	{
		token:"123asdacascascasc" // string
		refreshToken:"asdqwcqwcwcw" // string
	}
}
```

/api/login: post
```json
request:
{
	username string,
	password string //((md5)md5)
}

response:
{
	code:0,
	error:"",
	data:
	{
        token : "adsfasdfasdfasd"   //string
        refreshtoken:"adsfafasdadfas" //string
	}
}

```

/api/getUserInfo: get

```json
request: {
  token : "123123sqsdascsqc"    //用户token string
  refreshToken:"asdcnuawencue"  //用户refreshToken string
}

response: {
  userId:123        // 用户id long
  nickName:"pyystone" // 用户昵称 string
  token:"asdfadfasdf" //用户token string
}
```

/api/forgetPassword : post

```json

```


/api/refreshToken : post
```json
request: {
  userId : "123123",
  token : "asfd",
  refreshToken: "asdasdaq",
  ts : "12312312321"      // 时间戳
}


response: {
  token: "asdasd",
  refreshToken : "asdasdas"
}
```
