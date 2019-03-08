package bwei.com.chenxi20190308.data.bean;

import java.util.List;

public class ShopBean {


    private int status;
    private String message;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {


        private int id;
        private String name;
        private int restaurant_id;
        private String created_at;
        private int __v;
        private List<SpusBean> spus;
        private boolean shopChecked;

        public boolean isShopChecked() {
            return shopChecked;
        }

        public void setShopChecked(boolean shopChecked) {
            this.shopChecked = shopChecked;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRestaurant_id() {
            return restaurant_id;
        }

        public void setRestaurant_id(int restaurant_id) {
            this.restaurant_id = restaurant_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public List<SpusBean> getSpus() {
            return spus;
        }

        public void setSpus(List<SpusBean> spus) {
            this.spus = spus;
        }

        public static class SpusBean {

            private String _id;
            private int id;
            private int restaurant_id;
            private int category_id;
            private String name;
            private int praise_num;
            private String praise_content;
            private int month_saled;
            private String month_saled_content;
            private String pic_url;
            private int __v;
            private String created_at;
            private List<SkusBean> skus;
            private List<?> attrs;
            private List<?> status_remind_list;
            private double price=15.5;
            //新增字段：默认数字
            private int defalutNumber = 1;

            public int getDefalutNumber() {
                return defalutNumber;
            }

            public void setDefalutNumber(int defalutNumber) {
                this.defalutNumber = defalutNumber;
            }

            private boolean goodsChecked;

            public boolean isGoodsChecked() {
                return goodsChecked;
            }

            public void setGoodsChecked(boolean goodsChecked) {
                this.goodsChecked = goodsChecked;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            //            public String getPrice() {
//                return price;
//            }
//
//            public void setPrice(String price) {
//                this.price = price;
//            }

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getRestaurant_id() {
                return restaurant_id;
            }

            public void setRestaurant_id(int restaurant_id) {
                this.restaurant_id = restaurant_id;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPraise_num() {
                return praise_num;
            }

            public void setPraise_num(int praise_num) {
                this.praise_num = praise_num;
            }

            public String getPraise_content() {
                return praise_content;
            }

            public void setPraise_content(String praise_content) {
                this.praise_content = praise_content;
            }

            public int getMonth_saled() {
                return month_saled;
            }

            public void setMonth_saled(int month_saled) {
                this.month_saled = month_saled;
            }

            public String getMonth_saled_content() {
                return month_saled_content;
            }

            public void setMonth_saled_content(String month_saled_content) {
                this.month_saled_content = month_saled_content;
            }

            public String getPic_url() {
                return pic_url;
            }

            public void setPic_url(String pic_url) {
                this.pic_url = pic_url;
            }

            public int get__v() {
                return __v;
            }

            public void set__v(int __v) {
                this.__v = __v;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public List<SkusBean> getSkus() {
                return skus;
            }

            public void setSkus(List<SkusBean> skus) {
                this.skus = skus;
            }

            public List<?> getAttrs() {
                return attrs;
            }

            public void setAttrs(List<?> attrs) {
                this.attrs = attrs;
            }

            public List<?> getStatus_remind_list() {
                return status_remind_list;
            }

            public void setStatus_remind_list(List<?> status_remind_list) {
                this.status_remind_list = status_remind_list;
            }

            public static class SkusBean {
                /**
                 * description :
                 * price : 20.8
                 * id : 1090
                 * _id : 5ac5b0913714cc2d644f461f
                 */

                private String description;
                private String price;
                private int id;
                private String _id;

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String get_id() {
                    return _id;
                }

                public void set_id(String _id) {
                    this._id = _id;
                }
            }
        }
    }
}
