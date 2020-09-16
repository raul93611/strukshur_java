package utilities.property;

import org.testng.annotations.DataProvider;

public class DataProviderStore {

    @DataProvider
    public Object[] documentSetDataProvider()
    {

        return new Object[][]{

                {"Permissions",".jpg"},
                {"TextualFile",".txt"},
                {"Florence eBinder User Permissions",".docx"},
                {"PermissionsPDF",".pdf"},
                {"PermissionsPDFform",".pdf"}
        };
    }

    @DataProvider
    public Object[] documentDataProvider()
    {

        return new String[][]{

                {"Permissions.jpg"}
        };
    }
}

