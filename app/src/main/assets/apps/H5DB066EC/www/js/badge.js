/*
* 李留新
* 2018-01-31
* 说明:桌面角标扩展插件js
*/
document.addEventListener('plusready', function () {
  var _BARCODE = 'Badge' // 插件名称
  var B = window.plus.bridge

  var BadgePlugin = {
    callNative: function (fname, args, successCallback) {
      var callbackId = this.getCallbackId(successCallback, this.errorCallback)
      if (args != null) {
        args.unshift(callbackId)
      } else {
        var args = [callbackId]
      }
      return B.exec(_BARCODE, fname, args)
    },
    getCallbackId: function (successCallback) {
      var success = typeof successCallback !== 'function' ? null : function (args) {
        successCallback(args)
      }
      return B.callbackId(success, this.errorCallback)
    },
    errorCallback: function (errorMsg) {
      console.log('Javascript callback error: ' + errorMsg)
    },
    /*
    * 李留新
    * 2018-01-31
    * 说明:设置桌面角标显示数量
    * 参数:count:显示角标数量
    */
    setBadge: function (count) {
      this.callNative('setBadge', [count], null)
    },
    /*
     * 李留新
     * 2018-01-31
     * 说明:删除桌面角标
     */
    removeBadge: function () {
          this.callNative('removeBadge', null, null)
    }
  }
  window.plus.Badge = BadgePlugin
}, true)