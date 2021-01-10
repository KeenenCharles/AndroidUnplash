# Android Unsplash (Unofficial)
An unofficial Unsplash API library for Android

## Gradle
Add the line below to your build.gradle to use:
~~~
dependencies {
    implementation 'com.kc.androidunsplash:androidunsplash:2.0.3'
}
~~~

## Usage

### Initialize Unsplash Client
~~~~~
val unsplash = Unsplash(YOUR_CLIENT_ID, YOUR_TOKEN);
~~~~~
You can create an app for your project at <https://unsplash.com/developers>
You'll receive a Client ID and a Client Secret

### User Authentication
Unsplash uses OAuth2 for user authentication.

You can call the `authorize()` method to start the process with the scopes you require access to. Ensure those scopes have been turned on in the Unsplash project dashboard.

~~~~~
val scopes = listOf(Scope.PUBLIC, Scope.READ_USER, Scope.WRITE_USER)
unsplash.authorize(this, YOUR_REDIRECT_URI, scopes)
~~~~~

If your app is mobile only you can create a `redirectURI` by [defining a URI scheme](https://developer.android.com/training/app-links/deep-linking) in your Manifest 

Once the user has been redirected to your app you can need to retrieve the `code` parameter provided in the Intent and call the `getToken()` method.

~~~~~
unsplash.getToken(YOUR_SECRET, YOUR_REDIRECT_URI, code, {
		Log.d("Token", it.accessToken)
	}, {
		Log.d("Token", it)
	})
~~~~~

Add the token you receive to your unsplash client to authenticate user-related requests.
~~~~~
unsplash.setToken(token.accessToken);
~~~~~

### Get A List of Photos
~~~~~
unsplash.photos.get(1, 10, Order.LATEST, 
	onComplete = {
		Log.d("Photos", "Photos Found $it")
	},
	onError = {
		Log.d("Unsplash", it)
	}
)
~~~~~

### Get A Photo By Id
~~~~~
unsplash.photos.getById("ID",
	onComplete = {
		Log.d("Photos", "Photo Found $it")
	},
	onError = {
		Log.d("Photos", it)
	}
)
~~~~~

### Search
~~~~~
unsplash.photos.search(query,
	onComplete = {
		Log.d("Photos", "Total Results Found " + it.total!!)
		val photos = it.results
	},
	onError = {
		Log.d("Unsplash", it)
	}
)
~~~~~

## Other Features
You can access other features by using their respective classes.

Collections with `unsplash.collections`

Users with `unsplash.users`

Stats with `unsplash.stats`

Take a look at the API documentation for what each call does in detail <https://unsplash.com/documentation>

## Java

For Java support you can use the previous version of this library [here](https://github.com/KeenenCharles/AndroidUnplash/edit/master/README-JAVA.md)

## Built With This Library
+ [Walldrobe](https://play.google.com/store/apps/details?id=walldrobe.coffecode.com)
+ [Love Diary](https://play.google.com/store/apps/details?id=com.kilic.tweetydiary)
+ [Advice](https://play.google.com/store/apps/details?id=my.sustento.apeaceofadvice)

# License
~~~
MIT License

Copyright (c) 2017 Keenen Charles

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

~~~
