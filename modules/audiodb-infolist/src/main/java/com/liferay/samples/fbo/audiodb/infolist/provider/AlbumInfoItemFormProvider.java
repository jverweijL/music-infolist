package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.form.InfoForm;
import com.liferay.info.item.provider.InfoItemFormProvider;
import com.liferay.info.localized.InfoLocalizedValue;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.samples.fbo.audiodb.infolist.model.Album;

import java.util.Locale;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		service = InfoItemFormProvider.class
		)
public class AlbumInfoItemFormProvider  implements InfoItemFormProvider<Album> {

	@Override
	public InfoForm getInfoForm() {
		Set<Locale> availableLocales = LanguageUtil.getAvailableLocales();

		InfoLocalizedValue.Builder infoLocalizedValueBuilder =
			InfoLocalizedValue.builder();

		for (Locale locale : availableLocales) {
			infoLocalizedValueBuilder.value(
				locale,
				ResourceActionsUtil.getModelResource(
					locale, Album.class.getName()));
		}

		return InfoForm.builder(
		).infoFieldSetEntry(
				_albumInfoItemFieldSetProvider.getInfoFieldSet()
		).labelInfoLocalizedValue(
			infoLocalizedValueBuilder.build()
		).name(
			Album.class.getName()
		).build();	
	}
	
	@Reference
	private AlbumInfoItemFieldSetProvider _albumInfoItemFieldSetProvider;

}
