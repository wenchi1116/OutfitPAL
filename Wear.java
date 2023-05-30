package fourpeople.socute.outfitpal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Wear {
    private String[] imageUrl = new String[5];

    public void WearCrawler(Clothes clothes) throws Exception {
        // 訪問wear主頁的搭配頁面
        Document doc = Jsoup.connect("https://wear.tw/coordinate/").get();
        String gender = "";
        if (clothes.getGender() == "Man") {
            System.out.println("找到男生");
            gender = "/men-";
            Element genderLink = doc.selectFirst("a[href=/men-coordinate/]");
            if (genderLink != null) {
                String genderUrl = genderLink.attr("abs:href");
                doc = Jsoup.connect(genderUrl).get();
            }
        } else if (clothes.getGender() == "Woman") {
            System.out.println("找到女生");
            gender = "/women-";
            Element genderLink = doc.selectFirst("a[href=/women-coordinate/]");
            if (genderLink != null) {
                String genderUrl = genderLink.attr("abs:href");
                doc = Jsoup.connect(genderUrl).get();
            }
        }
        // 找到上衣的選項
        if (clothes.getClothestype() == "上衣") {
            // System.out.println("找到上衣");
            Element categoryLink = doc.selectFirst("a[href=" + gender + "category/tops/" + "]");
            if (categoryLink != null) {
                // System.out.println("真的找到T恤");
                String categoryUrl = categoryLink.attr("abs:href");
                doc = Jsoup.connect(categoryUrl).get(); // 進入上衣頁面
                // 在上衣選項中找到T恤並進入
                if (clothes.getClothes() == "T恤") {
                    // System.out.println("找到T恤");
                    Element shirtLink = doc.selectFirst("a[href=" + gender + "category/tops/tshirt-cutsew/" + "]");
                    if (shirtLink != null) {
                        String shirtUrl = shirtLink.attr("abs:href");
                        doc = Jsoup.connect(shirtUrl).get();
                    }
                }
                // 在上衣選項中找到襯衫並進入
                else if (clothes.getClothes() == "襯衫") {
                    // System.out.println("找到襯衫");
                    Element shirtLink = doc.selectFirst("a[href=" + gender + "category/tops/shirt-blouse/" + "]");
                    if (shirtLink != null) {
                        String shirtUrl = shirtLink.attr("abs:href");
                        doc = Jsoup.connect(shirtUrl).get();
                    }
                }
                // 在上衣選項中找到針織衫並進入
                else if (clothes.getClothes() == "針織衫") {
                    // System.out.println("找到針織衫");
                    Element shirtLink = doc.selectFirst("a[href=" + gender + "category/tops/knit-sweater/" + "]");
                    if (shirtLink != null) {
                        String shirtUrl = shirtLink.attr("abs:href");
                        doc = Jsoup.connect(shirtUrl).get();
                    }
                }
                // 在上衣選項中找到細肩帶背心並進入
                else if (clothes.getClothes() == "細肩帶背心") {
                    // System.out.println("找到細肩帶背心");
                    Element shirtLink = doc.selectFirst("a[href=" + gender + "category/tops/camisole/" + "]");
                    if (shirtLink != null) {
                        String shirtUrl = shirtLink.attr("abs:href");
                        doc = Jsoup.connect(shirtUrl).get();
                    }
                }
                // 在上衣選項中找到坦克背心並進入
                else if (clothes.getClothes() == "坦克背心") {
                    // System.out.println("找到坦克背心");
                    Element shirtLink = doc.selectFirst("a[href=" + gender + "category/tops/tank-tops/" + "]");
                    if (shirtLink != null) {
                        String shirtUrl = shirtLink.attr("abs:href");
                        doc = Jsoup.connect(shirtUrl).get();
                    }
                }
            }
        } else if (clothes.getClothestype() == "褲子") {
            Element categoryLink = doc.selectFirst("a[href=" + gender + "category/pants/" + "]");
            if (categoryLink != null) {
                String categoryUrl = categoryLink.attr("abs:href");
                doc = Jsoup.connect(categoryUrl).get(); // 進入褲子頁面
                // 在上衣選項中找到T恤並進入
                if (clothes.getClothes() == "牛仔褲") {
                    Element shirtLink = doc.selectFirst("a[href=" + gender + "category/pants/denim-pants/" + "]");
                    if (shirtLink != null) {
                        String shirtUrl = shirtLink.attr("abs:href");
                        doc = Jsoup.connect(shirtUrl).get();
                    }
                }
                // 在上衣選項中找到襯衫並進入
                else if (clothes.getClothes() == "休閒短褲") {
                    Element shirtLink = doc.selectFirst("a[href=" + gender + "category/pants/cargo-pants/" + "]");
                    if (shirtLink != null) {
                        String shirtUrl = shirtLink.attr("abs:href");
                        doc = Jsoup.connect(shirtUrl).get();
                    }
                }
                // 在上衣選項中找到針織衫並進入
                else if (clothes.getClothes() == "休閒長褲") {
                    Element shirtLink = doc.selectFirst("a[href=" + gender + "category/pants/chino-pants/" + "]");
                    if (shirtLink != null) {
                        String shirtUrl = shirtLink.attr("abs:href");
                        doc = Jsoup.connect(shirtUrl).get();
                    }
                }
            }
        } else if (clothes.getClothestype() == "連衣裙") {
            Element categoryLink = doc.selectFirst("a[href=" + gender + "category/skirt/" + "]");
            if (categoryLink != null) {
                String categoryUrl = categoryLink.attr("abs:href");
                doc = Jsoup.connect(categoryUrl).get(); // 進入上衣頁面
                // 在上衣選項中找到T恤並進入
                if (clothes.getClothes() == "裙子") {
                    Element shirtLink = doc.selectFirst("a[href=" + gender + "category/skirt/" + "]");
                    if (shirtLink != null) {
                        String shirtUrl = shirtLink.attr("abs:href");
                        doc = Jsoup.connect(shirtUrl).get();
                    }
                }
                // 在上衣選項中找到襯衫並進入
                else if (clothes.getClothes() == "牛仔裙") {
                    Element shirtLink = doc.selectFirst("a[href=" + gender + "category/skirt/denim-skirt/" + "]");
                    if (shirtLink != null) {
                        String shirtUrl = shirtLink.attr("abs:href");
                        doc = Jsoup.connect(shirtUrl).get();
                    }
                }
            }
        } else if (clothes.getClothestype() == "外套") {
            Element categoryLink = doc.selectFirst("a[href=" + gender + "category/jacket-outerwear/" + "]");
            if (categoryLink != null) {
                String categoryUrl = categoryLink.attr("abs:href");
                doc = Jsoup.connect(categoryUrl).get(); // 進入上衣頁面
                // 在上衣選項中找到T恤並進入
                if (clothes.getClothes() == "休閒西裝") {
                    Element shirtLink = doc
                            .selectFirst("a[href=" + gender + "category/jacket-outerwear/tailored-jacket/" + "]");
                    if (shirtLink != null) {
                        String shirtUrl = shirtLink.attr("abs:href");
                        doc = Jsoup.connect(shirtUrl).get();
                    }
                }
                // 在上衣選項中找到襯衫並進入
                else if (clothes.getClothes() == "牛仔外套") {
                    Element shirtLink = doc
                            .selectFirst("a[href=" + gender + "category/jacket-outerwear/denim-jacket/" + "]");
                    if (shirtLink != null) {
                        String shirtUrl = shirtLink.attr("abs:href");
                        doc = Jsoup.connect(shirtUrl).get();
                    }
                }
                // 在上衣選項中找到針織衫並進入
                else if (clothes.getClothes() == "短外套") {
                    Element shirtLink = doc.selectFirst("a[href=" + gender + "category/jacket-outerwear/jacket/" + "]");
                    if (shirtLink != null) {
                        String shirtUrl = shirtLink.attr("abs:href");
                        doc = Jsoup.connect(shirtUrl).get();
                    }
                }
                // 在上衣選項中找到細肩帶背心並進入
                else if (clothes.getClothes() == "運動外套") {
                    Element shirtLink = doc
                            .selectFirst("a[href=" + gender + "category/jacket-outerwear/stadium-jumper/" + "]");
                    if (shirtLink != null) {
                        String shirtUrl = shirtLink.attr("abs:href");
                        doc = Jsoup.connect(shirtUrl).get();
                    }
                }
                // 在上衣選項中找到坦克背心並進入
                else if (clothes.getClothes() == "毛呢大衣") {
                    Element shirtLink = doc
                            .selectFirst("a[href=" + gender + "category/jacket-outerwear/duffle-coat/" + "]");
                    if (shirtLink != null) {
                        String shirtUrl = shirtLink.attr("abs:href");
                        doc = Jsoup.connect(shirtUrl).get();
                    }
                }
            }
        }
        // 在選好的衣服頁面找到顏色的位子
        Element Links = doc.selectFirst("div.color_palet");
        Elements colorlinks = Links.select("a");
        // 在顏色位子裡找到白色的區塊並進入
        for (Element colorLink : colorlinks) {
            String href = colorLink.attr("abs:href");
            if (clothes.getClothescolor() == "白色系" && href.contains("color_group_id=1")) {
                doc = Jsoup.connect(href).get();
                // System.out.println("找到白色！");
                break;
            } else if (clothes.getClothescolor() == "黑色系" && href.contains("color_group_id=2")) {
                doc = Jsoup.connect(href).get();
                // System.out.println("找到黑色！");
                break;
            } else if (clothes.getClothescolor() == "灰色系" && href.contains("color_group_id=3")) {
                doc = Jsoup.connect(href).get();
                // System.out.println("找到灰色！");
                break;
            } else if (clothes.getClothescolor() == "棕色系" && href.contains("color_group_id=4")) {
                doc = Jsoup.connect(href).get();
                // System.out.println("找到棕色！");
                break;
            } else if (clothes.getClothescolor() == "米色系" && href.contains("color_group_id=5")) {
                doc = Jsoup.connect(href).get();
                // System.out.println("找到米色！");
                break;
            } else if (clothes.getClothescolor() == "綠色系" && href.contains("color_group_id=7")) {
                doc = Jsoup.connect(href).get();
                // System.out.println("找到綠色！");
                break;
            } else if (clothes.getClothescolor() == "藍色系" && href.contains("color_group_id=8")) {
                doc = Jsoup.connect(href).get();
                // System.out.println("找到藍色！");
                break;
            } else if (clothes.getClothescolor() == "紫色系" && href.contains("color_group_id=9")) {
                doc = Jsoup.connect(href).get();
                // System.out.println("找到紫色！");
                break;
            } else if (clothes.getClothescolor() == "黃色系" && href.contains("color_group_id=10")) {
                doc = Jsoup.connect(href).get();
                // System.out.println("找到黃色！");
                break;
            } else if (clothes.getClothescolor() == "粉色系" && href.contains("color_group_id=11")) {
                doc = Jsoup.connect(href).get();
                // System.out.println("找到粉色！");
                break;
            } else if (clothes.getClothescolor() == "紅色系" && href.contains("color_group_id=12")) {
                doc = Jsoup.connect(href).get();
                // System.out.println("找到紅色！");
                break;
            } else if (clothes.getClothescolor() == "橘色系" && href.contains("color_group_id=13")) {
                doc = Jsoup.connect(href).get();
                // System.out.println("找到橘色！");
                break;
            } else if (clothes.getClothescolor() == "銀色系" && href.contains("color_group_id=14")) {
                doc = Jsoup.connect(href).get();
                // System.out.println("找到銀色！");
                break;
            } else if (clothes.getClothescolor() == "金色系" && href.contains("color_group_id=15")) {
                doc = Jsoup.connect(href).get();
                // System.out.println("找到金色！");
                break;
            }

        }
        Document document = doc;
        int i = 0;
        Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
        for (Element image : images) {
            if (image.attr("height").equals("310")) {
                imageUrl[i] = "https://" + image.attr("data-originalRetina").substring(2);
                i++;
                if (i == 5)
                    break;

            }

        }
        // ShowImage clothesimage = new ShowImage(imageUrl[0]);
        // clothesimage.ShowClothesImage();

    }

    public String[] getimageUrl() {
        return imageUrl;
    }
}