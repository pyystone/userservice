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

/api/checkUserVaild : post
```json

```


errorCode:

