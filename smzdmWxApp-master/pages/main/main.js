// main.js
var pages = 0
Page({

  /**
   * 页面的初始数据
   */


  data: {
    list: [],
    discount: '优惠',
    worldbuy:'海淘',
    article: '好文',
    condition: false,
    duration: 2000,
    indicatorDots: true,
    autoplay: true,
    interval: 3000,
    loading: false,
    wrothy: '0',
    isHideLoadMore:false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {


    var that = this
    wx.showNavigationBarLoading()
   
    wx.request({
      url: 'https://api.smzdm.com/v1/home/articles?f=wxapp&wxapp=zdmapp&limit=20',
      header: {
        'Content-Type': 'application/json'
      },
      data: {
        offset: pages
      },
      method: 'GET',
      success: function (res) {



        that.setData({
          list: res.data.data.rows,
        })
      },
      fail: function () {

      },complete:function(){
        wx.hideNavigationBarLoading()
      }

    })

 
  },
  detail: function (event) {
    
   
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
    var that = this
    pages = 0


    wx.showNavigationBarLoading()
    wx.request({
      url: 'https://api.smzdm.com/v1/home/articles?f=wxapp&wxapp=zdmapp&limit=20',
      header: {
        'Content-Type': 'application/json'
      },
      data: {
        offset: pages
      },
      method: 'GET',
      success: function (res) {
     
        that.setData({
          list: res.data.data.rows
        })
   
      },
      fail: function () {
       
      },
      complete:function(){
        wx.hideNavigationBarLoading()
        wx.stopPullDownRefresh()
      }

    })


  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    pages += 20

    isHideLoadMore :true
    wx.showNavigationBarLoading()
  
    var that = this
    wx.request({
      url: 'https://api.smzdm.com/v1/home/articles?f=wxapp&wxapp=zdmapp&limit=20',
      header: {
        'Content-Type': 'application/json'
      },
      data: {
        offset: pages
      },
      method: 'GET',
      success: function (res) {
     
        var list = that.data.list.concat(res.data.data.rows)
        that.setData({

          list: list
        })
       
 
      },
      fail: function () {

      
      },complete:function(){
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