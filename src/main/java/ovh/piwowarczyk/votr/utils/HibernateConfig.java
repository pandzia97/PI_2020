package ovh.piwowarczyk.votr.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Klasa konfiguracyjna frameworku Hibernate</p>
 *
 * @author jpiwowarczyk
 */
@Configuration
public class HibernateConfig {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    /**
     * <p>Metoda udostępniająca Fabrykę Sesji Hibernate jako HibernateBean</p>
     *
     * @return Fabryka sesji {@link SessionFactory}.
     */
    @Bean
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();
                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);
                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();
                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }
    /**
     * <p>Metoda pomocnicza klasy konfiguracyjnej</p>
     */
    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
