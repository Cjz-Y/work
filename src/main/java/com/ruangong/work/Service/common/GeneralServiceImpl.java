package com.ruangong.work.Service.common;

import com.ruangong.work.Bean.AbstractBean;
import com.ruangong.work.Repository.common.GeneralRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.Id;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@Transactional
public abstract class GeneralServiceImpl<T extends AbstractBean<ID>, ID extends Serializable> implements GeneralService<T, ID> {

    protected GeneralRepository<T, ID> generalRepository;

    private String entityName;
    private Class<T> entityClass;
    private String pkName;

    public GeneralServiceImpl() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];

        this.entityName = this.entityClass.getSimpleName();

        Field[] fields = this.entityClass.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(Id.class)) {
                this.pkName = f.getName();
                break;
            }
        }
    }

    public abstract void setGeneralRepository(GeneralRepository<T, ID> generalRepository);

    @Override
    public T save(T entity) {
        Assert.notNull(entity, "Entity is null");
        return generalRepository.save(entity);
    }

    @Override
    public List<T> save(List<T> entities) {
        Assert.notNull(entities, "Entities is null");

        return generalRepository.saveAll(entities);
    }

    @Override
    public int deleteById(ID id) {
        generalRepository.deleteById(id);
        return 1;
    }

    @Override
    public int deleteById(ID[] ids) {
        for (ID id : ids) {
            generalRepository.deleteById(id);
        }
        return ids.length;
    }

    @Override
    public void delete(T entity) {
        if (entity != null) generalRepository.delete(entity);
    }

    @Override
    public void delete(List<T> entities) {
        if (entities != null) generalRepository.deleteAll(entities);
    }

    @Override
    public T update(T entity) {
        return save(entity);
    }

    @Override
    public List<T> update(List<T> entities) {
        return save(entities);
    }

    @Transactional(readOnly = true)
    @Override
    public T findById(ID id) {
        Optional result = generalRepository.findById(id);
        if (result.isPresent()){
            return (T) result.get();
        }   else    {
            return null;
        }
    }

    @Override
    public List<T> findAll() {
        return generalRepository.findAll();
    }
}
