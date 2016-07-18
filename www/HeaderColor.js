var headerColor = {
  tint: function (color, successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, 'HeaderColor', 'tint', [color]);
  }
}

if (!window.plugins) { window.plugins = {}; }

window.plugins.headerColor = headerColor;
return window.plugins.headerColor;
