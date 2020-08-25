window.GC = {
	ctx: location.origin,

	bctx: "http://localhost:8080/",

	imgCdn: "http://img.xxxx.com/",

	//判断是否是移动或是web
	browser: (function () {
		var ua = navigator.userAgent;
		//var app = navigator.appVersion;
		var mobile = !!ua.match(/AppleWebKit.*Mobile.*/),
			android = ua.match(/(Android)\s+([\d.]+)/),
			ios = ua.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),
			ipad = ua.match(/(iPad).*OS\s([\d_]+)/),
			ipod = ua.match(/(iPod).*OS\s([\d_]+)/),
			iphone = !ipod && !ipad && ua.match(/(iPhone\sOS)\s([\d_]+)/),
			kindle = ua.match(/Kindle\/([\d\.]+)/), // Kindle
			weixin = ua.match(/MicroMessenger\/([^\s]+)/), // 微信
			mqq = ua.match(/QQ\/([\d\.]+)/), // 手机QQ
			mqqbrowser = ua.match(/MQQBrowser\/([\d\.]+)/), // QQ浏览器
			ucbrowser = ua.match(/UCBrowser\/([\d\.]+)/); // UC浏览器

		return {
			mobile: mobile,
			android: android,
			ios: ios,
			ipad: ipad,
			ipod: ipod,
			iphone: iphone,
			kindle: kindle,
			weixin: weixin,
			mqq: mqq,
			mqqbrowser: mqqbrowser,
			ucbrowser: ucbrowser,
		};
	})(),

	/**
	 * 数字格式化 若数字大于99999返回：x万，否则返回原数字
	 *
	 * @param num
	 * @returns
	 */
	formatNumber: function (num) {
		if (!num) {
			return 0;
		}
		num = parseInt(num + "");
		if (num > 99999) {
			var result = parseInt(num / 10000);
			return result + "万";
		} else {
			return num;
		}
	},
};




window.HC = {
	/**
	 * 对发送到服务器的ajax请求数据进行修改和添加，减少手动编写的代码
	 *
	 * @param {Object} data ajax数据
	 * @returns 重构好的数据
	 */
	packAjaxData: function (data) {
		data.url = GC.bctx + data.url || "";
		data.headers = data.headers || {};
		data.headers["Authorization"] = iCookie.get("token");
		return data;
	},

	/**
	 * 这是提供给layui table的headers值
	 */
	token() {
		return {
			Authorization: iCookie.get("token"),
		};
	},

	/**
	 * 检查是否登录，没有登录则跳转至登录页
	 */
	loginCheck: function () {
		if (iCookie.get("token") === null) {
			// 额……使用origin而不能使用host，因为还有协议名……
			window.location.href = window.location.origin + "/login.html";
			return false;
		}
		return true;
	},

	/**
	 * 保存用户信息到Cookie
	 * @param {Object} user 用户信息
	 */
	saveUser(user) {
		iCookie.set("token", user.token, 172800);
		iCookie.set("username", user.user.userName, 172800);
		iCookie.set("usertype", user.user.userType, 172800);
	},

	/**
	 * 移除用户信息
	 */
	removeUser() {
		iCookie.remove("token");
		iCookie.remove("username");
		iCookie.remove("usertype");
	},

	page: {
		limit: 10,
		limits: [10, 15, 20, 25, 30],
	},
};





// /**
//  * 对发送到服务器的ajax请求数据进行修改和添加，减少手动编写的代码
//  *
//  * @param {Object} data ajax数据
//  * @returns 重构好的数据
//  */
// function packAjaxData(data) {
// 	data.url = GC.bctx + data.url || "";
// 	data.headers = data.headers || {};
// 	data.headers["Authorization"] = localStorage.getItem("token");
// 	return data;
// }

// /**
//  * 检查是否登录，没有登录则跳转至登录页
//  */
// function loginCheck() {
// 	if (iCookie.get("token") === null) {
// 		// 额……使用origin而不能使用host，因为还有协议名……
// 		window.location.href = window.location.origin + "/login.html";
// 		return false
// 	}
// 	return true
// }

class iCookie {
	/**
	 * 设置Cookie
	 * @param {String} key 键
	 * @param {Object} value 值
	 * @param {int} expire 有效时间，以分钟为单位
	 */
	static set(key, value, expire) {
		// 设置了超时时间
		if (expire) {
			localStorage.setItem(
				key,
				JSON.stringify({
					value: value,
					expire: Date.now() + expire * 60 * 1000,
				})
			);
		} else {
			localStorage.setItem(key, JSON.stringify({ value: value }));
		}
	}

	/**
	 * 获取Cookie
	 * @param {String} key 键
	 */
	static get(key) {
		let t = localStorage.getItem(key);
		if (t) {
			try {
				t = JSON.parse(t);
				if (t.expire && t.expire < Date.now()) {
					// 超时
					localStorage.removeItem(key)
					return null
				} else {
					return t.value;
				}
			} catch (error) {
				return t
			}
		}
		return null
	}

	/**
	 * 移除Cookie
	 * @param {String} key 键
	 */
	static remove(key) {
		localStorage.removeItem(key)
	}

}
