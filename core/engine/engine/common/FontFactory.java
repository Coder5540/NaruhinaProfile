//package engine.common;
//
//import java.util.HashMap;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.assets.AssetManager;
//import com.badlogic.gdx.files.FileHandle;
//import com.badlogic.gdx.graphics.Texture.TextureFilter;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//
//public class FontFactory {
//
//	HashMap<String, BitmapFont> fonts = new HashMap<String, BitmapFont>();
//	public BitmapFont fontWhite;
//
//	public FontFactory(AssetManager assetManager) {
//		fontWhite = new BitmapFont(Gdx.files.internal("font/testwhite.fnt"));
//	}
//
//	public BitmapFont loadFont(String filePath, int size) {
//		float SCALE = 1.0f * Gdx.graphics.getWidth() / R.SCREEN_HEIGHT;
//		if (SCALE < 1)
//			SCALE = 1;
//
//		boolean flip = false;
//		FileHandle fontFile = Gdx.files.internal(filePath);
//		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
//		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
//		parameter.size = (int) (size * SCALE);
//		parameter.characters = "Ffaáàảãạăắẳằẵặâấẩầẫậbcdđeéẻèẽẹêếể�?ễệghiíỉìĩịjklmnoóò�?õ�?ôốồổỗộơớ�?ởỡợpqrstuúùủũụưứừửữựvxyýỳỹỷỵwz A�?ÀẢÃẠĂẰẮẲẴẶÂẦẤẨẪẬBCD�?EÉÈẺẼẸÊẾỀỂỄỆGHI�?ÌỈĨỊJKLMNOÓÒỎÕỌÔ�?ỒỔỖỘƠỚỜỞỠỢPQRSTUÚÙỦŨỤƯỨỪỬỮỰVXY�?ỲỶỸỴWZ1234567890\"!`?'.,;:()[]{}<>|/@\\^$-%+=#_&~*";
//		parameter.flip = flip;
//		parameter.genMipMaps = true;
//		generator.generateData(parameter);
//		BitmapFont font = generator.generateFont(parameter);
//		font.setScale((float) (1.0 / SCALE));
//		font.getRegion().getTexture()
//				.setFilter(TextureFilter.Linear, TextureFilter.Linear);
//		generator.dispose();
//		return font;
//	}
//
//	public enum fontType {
//		Regular, Bold, Light, Italic, Medium
//	};
//
//	public BitmapFont getFont(int size, fontType type) {
//		if (fonts.get("font" + size + type.toString()) == null) {
//			fonts.put("font" + size + type.toString(),
//					loadFont("font/Roboto-" + type.toString() + ".ttf", size));
//		}
//		return fonts.get("font" + size + type.toString());
//	}
//
//	public BitmapFont getFont(int size) {
//		if (fonts.get("font" + size + fontType.Regular.toString()) == null) {
//			fonts.put(
//					"font" + size + fontType.Regular.toString(),
//					loadFont("font/Roboto-" + fontType.Regular.toString()
//							+ ".ttf", size));
//		}
//		return fonts.get("font" + size + fontType.Regular.toString());
//	}
//
//}
