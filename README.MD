# cordova-plugin-headercolor

**HeaderColor** is a cordova plugin to change color of header in multitask view. Android devices.

<img src="https://raw.githubusercontent.com/tomloprod/cordova-plugin-headercolor/master/headercolor.png" width="350"/>

## Supported Platforms

- Android

## Installation

Cordova:

    cordova plugin add https://github.com/tomloprod/cordova-plugin-headercolor

## Usage

This plugin exports an object with one method called "tint":

```javascript
window.plugins.headerColor.tint("#becb29");
```

You can also specify the header color in your `config.xml`:

```xml
<preference name="HeaderColor" value="#becb29" />
```
