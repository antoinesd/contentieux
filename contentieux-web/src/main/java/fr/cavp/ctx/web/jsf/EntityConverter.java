package fr.cavp.ctx.web.jsf;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.faces.component.PartialStateHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * Converter for JPA entities. Uses the id of the entity for the key.
 * 
 * @author <a href="http://community.jboss.org/people/LightGuard">Jason
 *         Porter</a>
 */
@FacesConverter("entityConverter")
public class EntityConverter implements javax.faces.convert.Converter,
		PartialStateHolder {

	private static final Object[] ZERO_ARGS = new Object[] {};

	private Map<String, Object> stateMap = new ConcurrentHashMap<String, Object>();
	private boolean initialStateMarked;
	private boolean isTransient;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		// final ValueExpression ve = component.getValueExpression("value");
		// final Class<?> entityType = ve.getExpectedType();
		// return entService.getEntityManager().find(entityType,
		// this.stateMap.get(value));
		Object res=stateMap.get(value);
		return res;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		final Serializable id = this.findId(value);
		final String idKey = value.getClass().getSimpleName() + id.hashCode();
		if (!this.stateMap.containsKey(idKey)) {
			this.stateMap.put(idKey,
					value);
		}

		return idKey;
	}

	private Serializable findId(Object entity) {
		Serializable res = null;
		try {
			res = (Serializable) PropertyUtils.getProperty(entity, "id");
		} catch (Exception e) {
			throw new IllegalStateException(
					"Impossible de récupérer l'id dans la classe "
							+ entity.getClass().getName());
		}
		return res;

	}

	// ---------- State saving --------------
	@Override
	public void markInitialState() {
		this.initialStateMarked = true;
	}

	@Override
	public boolean initialStateMarked() {
		return this.initialStateMarked;
	}

	@Override
	public void clearInitialState() {
		this.stateMap = new ConcurrentHashMap<String, Object>();
		this.initialStateMarked = false;
	}

	@Override
	public Object saveState(FacesContext context) {
		if (context == null) {
			throw new IllegalArgumentException("FacesContext must not be null");
		}

		return Collections.unmodifiableMap(this.stateMap);
	}

	@Override
	public void restoreState(FacesContext context, Object state) {
		if (state != null) {
			this.stateMap = new ConcurrentHashMap<String, Object>(
					(Map<? extends String, ? extends Object>) state);
			return;
		}

		this.stateMap.clear();
	}

	@Override
	public boolean isTransient() {
		return this.isTransient;
	}

	@Override
	public void setTransient(boolean newTransientValue) {
		this.isTransient = newTransientValue;
	}
}