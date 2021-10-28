package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.item.capability.InfoItemCapability;
import com.liferay.info.item.provider.InfoItemCapabilitiesProvider;
import com.liferay.layout.page.template.info.item.capability.DisplayPageInfoItemCapability;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.samples.fbo.audiodb.infolist.model.Track;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		service = InfoItemCapabilitiesProvider.class
)
public class TrackInfoItemCapabilitiesProvider implements InfoItemCapabilitiesProvider<Track> {

	@Override
	public List<InfoItemCapability> getInfoItemCapabilities() {
		return ListUtil.fromArray(_displayPageInfoItemCapability);
	}

	@Reference
	private DisplayPageInfoItemCapability _displayPageInfoItemCapability;
	
}
