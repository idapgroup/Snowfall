# Snowfall Compose

[![](https://jitpack.io/v/idapgroup/Snowfall.svg)](https://jitpack.io/#idapgroup/Snowfall)

Small Android Snowfall compose animation

![snowfall-base](https://github.com/idapgroup/Snowfall/assets/12797421/965be48e-c21e-4660-a6d5-4035cc4089d4)

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
  implementation 'com.github.idapgroup:Snowfall:<latest-version>'
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

#### Custom flakes
If you want to customize snowflakes to any other image, the library allows you to put any painter list to make your own flakes animation.
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

#### Colors list and density
It is also possible to randomize different colors and flakes density for your purposes.
```kotlin
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .snowfall(
                  colors = listOf(Color.Green, Color.Yellow, Color.Blue, Color.Red),
                  density = 0.5 // from 0.0 to 1.0
                )
        )
```
[snowfall-colors-dencity.webm](https://github.com/idapgroup/Snowfall/assets/12797421/ef466018-5ddc-418d-819d-ab3c451e6ee4)

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
    val data = listOf(
        rememberVectorPainter(image = Icons.Rounded.Add),
        rememberVectorPainter(image = Icons.Rounded.AccountBox),
        rememberVectorPainter(image = Icons.Rounded.Abc),
        rememberVectorPainter(image = Icons.Rounded.Alarm),
    )
    val colors = listOf(Color.Yellow, Color.Blue, Color.Red, Color.Green, Color.Cyan)
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(400.dp)
            .background(Color.DarkGray, shape = RoundedCornerShape(8.dp))
            .snowmelt(
                type = FlakeType.Custom(data),
                colors = colors,
                density = 0.2
            )
    )
```
[snowmelt-custom-colors-density.webm](https://github.com/idapgroup/Snowfall/assets/12797421/f50c9616-8617-43d1-bc7b-024480d433d4)


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

## Kudos

Big thanks to ![Volodymyr Kondratenko](https://github.com/ochkarik05) for inspiriation and source code for the first version of this library.








