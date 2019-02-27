package de.ics.cardmarket4j.structs;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonObject;
import com.neovisionaries.i18n.LanguageCode;

import de.ics.cardmarket4j.CardMarketUtils;
import de.ics.cardmarket4j.JsonIO;
import de.ics.cardmarket4j.enums.Condition;

/**
 * 
 * @see https://www.mkmapi.eu/ws/documentation/API_2.0:Entities:Article
 * @author QUE
 *
 */
public class Article {
	private int articleId;
	private int productId;
	private LanguageCode language;
	private String comment;
	private BigDecimal price;
	private int quantity;
	private boolean inShoppingCart;
	private Product product;
	private User seller;
	private LocalDateTime lastEdited;
	private Condition condition;
	private boolean foil;
	private boolean signed;
	private boolean altered;
	private boolean playset;
	private boolean firstEdition;

	public Article(int articleId, int productId, LanguageCode language, String comment, BigDecimal price, int quantity,
			boolean inShoppingCart, Product product, User seller, LocalDateTime lastEdited, Condition condition,
			boolean foil, boolean signed, boolean altered, boolean playset, boolean firstEdition) {
		this.articleId = articleId;
		this.productId = productId;
		this.language = language;
		this.comment = comment;
		this.price = price;
		this.quantity = quantity;
		this.inShoppingCart = inShoppingCart;
		this.product = product;
		this.seller = seller;
		this.lastEdited = lastEdited;
		this.condition = condition;
		this.foil = foil;
		this.signed = signed;
		this.altered = altered;
		this.playset = playset;
		this.firstEdition = firstEdition;
	}

	public Article(JsonObject jObject) {
		this.articleId = JsonIO.parseInteger(jObject, "idArticle");
		this.productId = JsonIO.parseInteger(jObject, "idProduct");
		this.language = CardMarketUtils
				.fromLanguageId(JsonIO.parseInteger(jObject.get("language").getAsJsonObject(), "idLanguage"));
		this.comment = JsonIO.parseString(jObject, "comments");
		this.price = JsonIO.parseBigDecimal(jObject, "price");
		this.quantity = JsonIO.parseInteger(jObject, "count");
		this.inShoppingCart = JsonIO.parseBoolean(jObject, "inShoppingCart");
		this.product = new Product(jObject.get("product").getAsJsonObject());
		this.seller = new User(jObject.get("seller").getAsJsonObject());
		this.lastEdited = JsonIO.parseLocalDateTime(jObject, "lastEdited", DateTimeFormatter.ISO_DATE_TIME);
		this.condition = Condition.parseId(JsonIO.parseString(jObject, "condition"));
		this.foil = JsonIO.parseBoolean(jObject, "isFoil");
		this.signed = JsonIO.parseBoolean(jObject, "isSigned");
		this.altered = JsonIO.parseBoolean(jObject, "isAltered");
		this.playset = JsonIO.parseBoolean(jObject, "isPlayset");
		this.firstEdition = JsonIO.parseBoolean(jObject, "isFirstEd");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (altered != other.altered)
			return false;
		if (articleId != other.articleId)
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (condition != other.condition)
			return false;
		if (firstEdition != other.firstEdition)
			return false;
		if (foil != other.foil)
			return false;
		if (inShoppingCart != other.inShoppingCart)
			return false;
		if (language != other.language)
			return false;
		if (lastEdited == null) {
			if (other.lastEdited != null)
				return false;
		} else if (!lastEdited.equals(other.lastEdited))
			return false;
		if (playset != other.playset)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productId != other.productId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (seller == null) {
			if (other.seller != null)
				return false;
		} else if (!seller.equals(other.seller))
			return false;
		if (signed != other.signed)
			return false;
		return true;
	}

	public int getArticleId() {
		return articleId;
	}

	public String getComment() {
		return comment;
	}

	public Condition getCondition() {
		return condition;
	}

	public LanguageCode getLanguage() {
		return language;
	}

	public LocalDateTime getLastEdited() {
		return lastEdited;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Product getProduct() {
		return product;
	}

	public int getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public User getSeller() {
		return seller;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (altered ? 1231 : 1237);
		result = prime * result + articleId;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((condition == null) ? 0 : condition.hashCode());
		result = prime * result + (firstEdition ? 1231 : 1237);
		result = prime * result + (foil ? 1231 : 1237);
		result = prime * result + (inShoppingCart ? 1231 : 1237);
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((lastEdited == null) ? 0 : lastEdited.hashCode());
		result = prime * result + (playset ? 1231 : 1237);
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + productId;
		result = prime * result + quantity;
		result = prime * result + ((seller == null) ? 0 : seller.hashCode());
		result = prime * result + (signed ? 1231 : 1237);
		return result;
	}

	public boolean isAltered() {
		return altered;
	}

	public boolean isFirstEdition() {
		return firstEdition;
	}

	public boolean isFoil() {
		return foil;
	}

	public boolean isInShoppingCart() {
		return inShoppingCart;
	}

	public boolean isPlayset() {
		return playset;
	}

	public boolean isSigned() {
		return signed;
	}

	public void setAltered(boolean altered) {
		this.altered = altered;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public void setFirstEdition(boolean firstEdition) {
		this.firstEdition = firstEdition;
	}

	public void setFoil(boolean foil) {
		this.foil = foil;
	}

	public void setInShoppingCart(boolean inShoppingCart) {
		this.inShoppingCart = inShoppingCart;
	}

	public void setLanguage(LanguageCode language) {
		this.language = language;
	}

	public void setLastEdited(LocalDateTime lastEdited) {
		this.lastEdited = lastEdited;
	}

	public void setPlayset(boolean playset) {
		this.playset = playset;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public void setSigned(boolean signed) {
		this.signed = signed;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", productId=" + productId + ", "
				+ (language != null ? "language=" + language + ", " : "")
				+ (comment != null ? "comment=" + comment + ", " : "") + (price != null ? "price=" + price + ", " : "")
				+ "quantity=" + quantity + ", inShoppingCart=" + inShoppingCart + ", "
				+ (product != null ? "product=" + product + ", " : "")
				+ (seller != null ? "seller=" + seller + ", " : "")
				+ (lastEdited != null ? "lastEdited=" + lastEdited + ", " : "")
				+ (condition != null ? "condition=" + condition + ", " : "") + "foil=" + foil + ", signed=" + signed
				+ ", altered=" + altered + ", playset=" + playset + ", firstEdition=" + firstEdition + "]";
	}
}
