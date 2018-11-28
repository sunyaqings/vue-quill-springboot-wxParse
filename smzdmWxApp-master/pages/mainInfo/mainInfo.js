// pages/mainInfo/mainInfo.js
var WxParse = require('../../wxParse/wxParse.js')
var title
var id
Page({

  /**
   * 页面的初始数据
   */
  data: {
    display:'none',
    choice: '精选',
    duration: 2000,
    indicatorDots: true,
    autoplay: true,
    interval: 3000

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    id = options.id
    wx.request({
      url: 'https://api.smzdm.com/v1/wxapp/zdmapp/youhui_detail?f=wxapp&wxapp=zdmapp',
      data: {
        id: options.id
      },
      method: 'GET'
      , success: function (res) {


        that.setData({
          display:'flex',
          title: res.data.data.article_title,
          article_pic: res.data.data.article_pic,
          bannerLenght: res.data.data.article_product_focus_pic_url.length,
          banner: res.data.data.article_product_focus_pic_url,
          mall: res.data.data.article_mall,
          date: res.data.data.article_format_date,
          article_referrals: '爆料人：' + res.data.data.article_referrals,
          article_title: res.data.data.article_title,
          article_price: res.data.data.article_price,
          article_phrase_desc: res.data.data.article_phrase_desc

        })



        WxParse.wxParse('article_content', 'html', res.data.data.article_content, that, 5);
        WxParse.wxParse('product_intro', 'html', res.data.data.product_intro, that, 5);


      }

    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    wx.stopPullDownRefresh()
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    if (res.from == 'botton') {

    }
    return {
      title: title,
      path: 'pages/mainInfo/mainInfo?id={{id}}',
      success: function (res) {
      }
    }
  }
})