// pages/articleList/articleList  .js
var pages = 0
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: [],
    isHideLoadMore:false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.showNavigationBarLoading()
    var that = this
    wx.request({
      url: 'https://api.smzdm.com/v1/wxapp/zdmapp/good_articles_list?f=wxapp&wxapp=zdmapp&limit=20',
      header: {
        'Context-Type': 'application/json'

      }
      ,
      data: {
        offset: pages
      }
      ,
      success: function (res) {
     
        that.setData({
          list: res.data.data

        })

      },
      fail: function () {
      
      },
      complete:function(){
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
    pages = 0
    wx.startPullDownRefresh()
    wx.showNavigationBarLoading()
    var that = this
    wx.request({
      url: 'https://api.smzdm.com/v1/wxapp/zdmapp/good_articles_list?f=wxapp&wxapp=zdmapp&limit=20',
      header: {
        'Context-Type': 'application/json'

      }
      ,
      data: {
        offset: pages
      }
      ,
      success: function (res) {
     
      
        that.setData({
          list: res.data.data
        })

      },
      fail: function () {
      
      },
      complete: function () {
        wx.hideNavigationBarLoading()
        wx.stopPullDownRefresh()
      }
    })
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    isHideLoadMore:true
    var that = this
    pages += 20
   
   
    wx.showNavigationBarLoading()
    wx.request({
      url: 'https://api.smzdm.com/v1/wxapp/zdmapp/good_articles_list?f=wxapp&wxapp=zdmapp&limit=20',
      header: {
        'Context-Type': 'application/json'
      }
      ,
      data: {
        offset: pages
      }
      ,
      success: function (res) {
    
    
        var list = that.data.list.concat(res.data.data)
        that.setData({
          list: list
        })

      },
      fail: function () {
       
      },
      complete:function(){
        wx.hideNavigationBarLoading()
      }
    })


  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})