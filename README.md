# Snowfall
Snowfall animation for Android compose

[snowfall-base.webm](https://github.com/idapgroup/Snowfall/assets/12797421/237a6f42-d862-456d-9221-6e0a1e451e5d)
## Setup
Please, add to repositories jitpack:
```groovy
repositories {
  mavenCentral()
  ...
  maven { url 'https://jitpack.io' }
}
```
Add to your module next dependency:
```groovy
dependencies {
  implementation 'com.github.idapgroup:Snowfall:0.7.1'
}
```
`Note:` Do not forget to add compose dependencies 🙃

## Usage sample
Library has 2 base functions to use as an extension function for `Modifier`.
### Snowfall
It is pretty simple to use. Just add `.snowfall()` to any modifier where you want to see the animation
```kotlin
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .snowfall()
        )
```

It also allows you to put any painter list to make your own `any`flakes animation.
```kotlin
        val data = listOf(
            rememberVectorPainter(image = Icons.Rounded.Add),
            rememberVectorPainter(image = Icons.Rounded.AccountBox),
            rememberVectorPainter(image = Icons.Rounded.Abc),
            rememberVectorPainter(image = Icons.Rounded.Alarm),
        )
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(400.dp)
                .background(Color.Black, shape = RoundedCornerShape(8.dp))
                .snowfall(FlakeType.Custom(data))
        )

```
[icon-falling.webm](https://github.com/idapgroup/Snowfall/assets/12797421/6ad70d1e-b085-459d-a775-b7f3c20b5d98)
### Snowmelt
Melting has the same usage as a falling.
```kotlin
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(400.dp)
                .background(Color.DarkGray, shape = RoundedCornerShape(16.dp))
                .snowmelt()
        )
```
[snowmelting.webm](https://github.com/idapgroup/Snowfall/assets/12797421/76f1f1c9-ec25-488c-b75b-a32776e6c46c)

And also allows you to customize flakes:
```kotlin
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(400.dp)
                .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                .snowmelt(FlakeType.Custom(data))
        )
```
[melting-custom.webm](https://github.com/idapgroup/Snowfall/assets/12797421/fb40b686-c95a-4dae-98c4-4e5194a97f84)

### Combining

You can also combine as many options as you want:

```kotlin
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(350.dp)
                .background(Color.DarkGray, shape = RoundedCornerShape(8.dp))
                .snowfall()
                .snowmelt()
        )
```
[combining.webm](https://github.com/idapgroup/Snowfall/assets/12797421/dbca6ac0-b84d-4e32-8328-125df552d259)







