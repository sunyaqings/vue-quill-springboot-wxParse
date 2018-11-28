// pages/articleInfo/articleInfo.js

var WxParse=require('../../wxParse/wxParse.js')
var title
var id
Page({

  /**
   * 页面的初始数据
   */
  data: {
   display:'none'
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    id=options.id
    var that = this
    wx.showNavigationBarLoading()
  
    wx.request({
      url: 'http://localhost:8181/test/testQueryMarkDownById',
      data: {
        id: options.id
      }
      ,
      method: 'GET',
      success: function (res) {

        that.setData({
          display:'flex',
          title: res.data.data.title
        })
        WxParse.wxParse('content', 'html', res.data.data.content, that)
      },
      complete: function () {

        wx.hideNavigationBarLoading()
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
      path: 'pages/articleInfo/articleInfo?id={{id}}',
      success: function (res) {

   
      }
    }
  }
})